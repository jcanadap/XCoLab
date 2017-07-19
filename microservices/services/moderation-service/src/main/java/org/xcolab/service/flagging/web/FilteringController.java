package org.xcolab.service.flagging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.model.tables.pojos.FilteredEntry;
import org.xcolab.service.flagging.domain.filteredentry.FilteredEntryDao;
import org.xcolab.service.flagging.enums.FilteringStatus;
import org.xcolab.service.flagging.exceptions.NotFoundException;
import org.xcolab.service.flagging.utils.filteringprocessor.EntryFilteringProcessor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class FilteringController {

    private final FilteredEntryDao filteredEntryDao;

    private final EntryFilteringProcessor processor;

    @Autowired
    public FilteringController(FilteredEntryDao filteredEntryDao, EntryFilteringProcessor
            processor) {
        this.filteredEntryDao = filteredEntryDao;
        this.processor = processor;
    }

    @PostMapping("/filteredEntries")
    public FilteredEntry filterEntry(@RequestBody FilteredEntry filteredEntry) {

        filteredEntry.setStatus(FilteringStatus.CREATED.getId());
        filteredEntry.setCreatedAt(new Timestamp(new Date().getTime()));
        filteredEntry.setUuid(UUID.randomUUID().toString());
        FilteredEntry aux = filteredEntryDao.create(filteredEntry);
        FilteredEntry afterProcess = processor.processEntry(aux);
        if (afterProcess != null) {
            filteredEntryDao.update(afterProcess);
        }
        return aux;

    }

    @GetMapping("/filteredEntries/{uuid}")
    public FilteredEntry getByUUID(@PathVariable String uuid) throws NotFoundException {
        return filteredEntryDao.getByUuid(uuid);
    }

    @PutMapping("/filteredEntries/{filteredEntryId}")
    public boolean updateProposal(@RequestBody FilteredEntry filteredEntry,
                                  @PathVariable("filteredEntryId") Long filteredEntryId) throws NotFoundException {

        if (filteredEntryId == null || filteredEntryId == 0 || filteredEntryDao.get(filteredEntryId) == null) {
            throw new NotFoundException("No filteredEntry with id " + filteredEntryId);
        } else {
            return filteredEntryDao.update(filteredEntry);
        }
    }

    @GetMapping("/filteredEntries/processCreatedEntries")
    public void processCreatedEntries() {
        List<FilteredEntry> entriesToProcess = filteredEntryDao.getByStatus(FilteringStatus.CREATED.getId());
        if (entriesToProcess != null) {
            for (FilteredEntry entry : entriesToProcess) {
                FilteredEntry afterProcess = processor.processEntry(entry);
                if (afterProcess != null) {
                    filteredEntryDao.update(afterProcess);
                }
            }
        }
    }
}
