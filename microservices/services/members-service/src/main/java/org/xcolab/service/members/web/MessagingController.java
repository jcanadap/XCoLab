package org.xcolab.service.members.web;

import org.xcolab.service.members.domain.messaging.MessageDao;
import org.xcolab.service.members.exceptions.NotFoundException;
import org.xcolab.service.members.service.messaging.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xcolab.model.tables.pojos.Message;
import org.xcolab.model.tables.pojos.User_;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MessagingController {

    private static final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private MessagingService messagingService;

    @Autowired
    private MessageDao messageDao;

    @RequestMapping(value = "/messages", method = {RequestMethod.GET, RequestMethod.HEAD})
    public List<Message> getMemberMessages(HttpServletResponse response,
            @RequestParam(required = false) Integer firstRecord,
            @RequestParam(required = false) Integer lastRecord,
            @RequestParam(required = false) Long recipientId,
            @RequestParam(required = false) Long senderId,
            @RequestParam(required = false) Boolean isArchived,
            @RequestParam(required = false) Boolean isOpened,
            @RequestParam(required = false, defaultValue = "true") boolean includeCount) {

        final int firstRecordUnwrapped = firstRecord != null ? firstRecord : 0;
        final int lastRecordUnwrapped = lastRecord != null ? lastRecord : firstRecordUnwrapped + DEFAULT_PAGE_SIZE;

        if (includeCount) {
            response.setHeader("X-Total-Count",
                    Integer.toString(messageDao.countByGiven(senderId, recipientId, isArchived, isOpened)));
        }
        return messageDao.findByGiven(firstRecordUnwrapped, lastRecordUnwrapped, senderId, recipientId, isArchived, isOpened);
    }

    @RequestMapping(value = "/messages/{messageId}", method = RequestMethod.GET)
    public Message getMessage(@PathVariable("messageId") long messageId) throws NotFoundException {
        if (messageId == 0) {
            throw new NotFoundException("No message id given");
        } else {
            return messageDao.getMessage(messageId);
        }
    }

    @RequestMapping(value = "/messages/{messageId}/recipients", method = RequestMethod.GET)
    public List<User_> getMessageRecipients(@PathVariable("messageId") long messageId) throws NotFoundException {
        if (messageId == 0) {
            throw new NotFoundException("No message id given");
        } else {
            return messageDao.getRecipients(messageId);
        }
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public void createMessage(@RequestBody Message message) {
        messagingService.createMessage(message.getMessageId(), message.getFromId(), message.getRepliesTo(),
                message.getSubject(), message.getContent());
    }

    @RequestMapping(value = "/messages/{messageId}/recipients", method = RequestMethod.POST)
    public void createMessageRecipient(@PathVariable("messageId") long messageId,
            @RequestParam long recipientStatusId, //TODO: liferay generated id
            @RequestParam long recipientId) {
        messagingService.createRecipient(recipientStatusId, messageId, recipientId);
    }

    //TODO: patch doesn't work
    @RequestMapping(value = "/messages/{messageId}", method = RequestMethod.PUT)
    public void patchMessage(@PathVariable("messageId") long messageId,
            @RequestParam Long memberId,
            @RequestParam(required = false) Boolean isArchived,
            @RequestParam(required = false) Boolean isOpened) {
        if (isOpened != null) {
            messageDao.setOpened(messageId, memberId, isOpened);
        }
        if (isArchived != null) {
            messageDao.setArchived(messageId, memberId, isArchived);
        }
    }
}