package org.xcolab.client.contents;

import org.xcolab.client.contents.exceptions.ContentNotFoundException;
import org.xcolab.client.contents.pojo.ContentArticle;
import org.xcolab.client.contents.pojo.ContentArticleVersion;
import org.xcolab.client.contents.pojo.ContentFolder;
import org.xcolab.client.contents.pojo.ContentPage;
import org.xcolab.util.clients.CoLabService;
import org.xcolab.util.http.ServiceRequestUtils;
import org.xcolab.util.http.caching.CacheName;
import org.xcolab.util.http.client.RestResource;
import org.xcolab.util.http.client.RestResource1;
import org.xcolab.util.http.client.RestService;
import org.xcolab.util.http.exceptions.EntityNotFoundException;

import java.util.List;

public final class ContentsClient {

    private static final RestService contentService = new RestService(CoLabService.CONTENT,
            ServiceRequestUtils.getNamespace());

    private static final RestResource<ContentArticle, Long> contentArticleResource =
            new RestResource1<>(contentService, "contentArticles", ContentArticle.TYPES);
    private static final RestResource<ContentArticleVersion, Long> contentArticleVersionResource =
            new RestResource1<>(contentService, "contentArticleVersions",
                    ContentArticleVersion.TYPES);
    private static final RestResource1<ContentFolder, Long> contentFolderResource =
            new RestResource1<>(contentService, "contentFolders", ContentFolder.TYPES);
    private static final RestResource<ContentPage, Long> contentPageResource =
            new RestResource1<>(contentService, "contentPages", ContentPage.TYPES);

    private ContentsClient() {
    }

    public static List<ContentArticle> getContentArticles(Long folderId) {
        return contentArticleResource.list()
                .optionalQueryParam("folderId", folderId)
                .withCache(CacheName.CONTENT)
                .execute();
    }

    public static ContentArticleVersion getLatestContentArticleVersion(long folderId, String title)
            throws ContentNotFoundException {
        final ContentArticleVersion contentArticleVersion = contentArticleVersionResource.list()
                .queryParam("ancestorFolderId", folderId)
                .queryParam("title", title)
                .queryParam("sort", "-contentArticleVersion")
                .withCache(CacheName.CONTENT)
                .executeWithResult().getFirstIfExists();
        if (contentArticleVersion == null) {
            throw new ContentNotFoundException("No ContentArticleVersion with title " + title
                    + " found in folder " + folderId);
        }
        return contentArticleVersion;
    }

    public static ContentArticleVersion getLatestContentArticleVersion(long articleId)
            throws ContentNotFoundException {
        final ContentArticleVersion contentArticleVersion = contentArticleVersionResource.list()
                .queryParam("contentArticleId", articleId)
                .queryParam("sort", "-contentArticleVersion")
                .withCache(CacheName.CONTENT)
                .executeWithResult().getFirstIfExists();
        if (contentArticleVersion == null) {
            throw new ContentNotFoundException(
                    "No ContentArticleVersion for contentArticleID " + articleId);
        }
        return contentArticleVersion;
    }

    public static List<ContentArticleVersion> getContentArticleVersions(Integer startRecord,
            Integer limitRecord, Long folderId, Long contentArticleId,
            Long contentArticleVersion, String title) {
        return contentArticleVersionResource.list()
                .optionalQueryParam("startRecord", startRecord)
                .optionalQueryParam("limitRecord", limitRecord)
                .optionalQueryParam("contentArticleId", contentArticleId)
                .optionalQueryParam("folderId", folderId)
                .optionalQueryParam("contentArticleVersion", contentArticleVersion)
                .optionalQueryParam("title", title)
                .optionalQueryParam("sort","-contentArticleVersion")
                .withCache(CacheName.CONTENT)
                .execute();
    }

    public static List<ContentFolder> getContentFolders() {
        return contentFolderResource.list().execute();
    }

    public static List<ContentFolder> getContentFolders(Long parentFolderId) {
        return contentFolderResource.list()
                .queryParam("parentFolderId", parentFolderId)
                .withCache(CacheName.CONTENT)
                .execute();
    }

    public static ContentArticle getContentArticle(Long contentArticleId)
            throws ContentNotFoundException {
        try {
            return contentArticleResource.get(contentArticleId)
                    .withCache(CacheName.CONTENT)
                    .executeChecked();
        } catch (EntityNotFoundException e) {
            throw new ContentNotFoundException(
                    "ContentArticle " + contentArticleId + " does not exist");
        }
    }

    public static ContentArticle createContentArticle(ContentArticle contentArticle) {
        final ContentArticle result = contentArticleResource.create(contentArticle)
                .execute();
        //TODO: fine-grained cache control
        ServiceRequestUtils.clearCache(CacheName.CONTENT);
        return result;
    }

    public static boolean updateContentArticle(ContentArticle contentArticle) {
        final Boolean result =
                contentArticleResource.update(contentArticle, contentArticle.getContentArticleId())
                        .cacheName(CacheName.CONTENT)
                        .execute();
        //TODO: fine-grained cache control
        ServiceRequestUtils.clearCache(CacheName.CONTENT);
        return result;
    }

    public static ContentArticleVersion getContentArticleVersion(Long contentArticleVersionId)
            throws ContentNotFoundException {
        try {
            return contentArticleVersionResource.get(contentArticleVersionId)
                    .withCache(CacheName.CONTENT)
                    .executeChecked();
        } catch (EntityNotFoundException e) {
            throw new ContentNotFoundException(
                    "ContentArticleVersion " + contentArticleVersionId + " does not exist");
        }
    }

    public static ContentArticleVersion createContentArticleVersion(
            ContentArticleVersion contentArticleVersion) {
        final ContentArticleVersion result =
                contentArticleVersionResource.create(contentArticleVersion).execute();
        //TODO: fine-grained cache control
        ServiceRequestUtils.clearCache(CacheName.CONTENT);
        return result;
    }

    public static boolean updateContentArticleVersion(ContentArticleVersion contentArticleVersion) {
        final Boolean result = contentArticleVersionResource
                .update(contentArticleVersion, contentArticleVersion.getContentArticleVersionId())
                .cacheName(CacheName.CONTENT)
                .execute();
        //TODO: fine-grained cache control
        ServiceRequestUtils.clearCache(CacheName.CONTENT);
        return result;
    }

    public static ContentFolder getContentFolder(long contentFolderId)
            throws ContentNotFoundException {
        try {
            return contentFolderResource.get(contentFolderId)
                    .withCache(CacheName.CONTENT)
                    .executeChecked();
        } catch (EntityNotFoundException e) {
            throw new ContentNotFoundException(
                    "ContentFolder " + contentFolderId + " does not exist");
        }
    }

    public static ContentFolder createContentFolder(ContentFolder contentFolder) {
        final ContentFolder result = contentFolderResource.create(contentFolder).execute();
        //TODO: fine-grained cache control
        ServiceRequestUtils.clearCache(CacheName.CONTENT);
        return result;
    }

    public static boolean updateContentFolder(ContentFolder contentFolder) {
        final Boolean result =
                contentFolderResource.update(contentFolder, contentFolder.getContentFolderId())
                        .cacheName(CacheName.CONTENT)
                        .execute();
        //TODO: fine-grained cache control
        ServiceRequestUtils.clearCache(CacheName.CONTENT);
        return result;
    }

    public static ContentPage createContentPage(ContentPage contentPage) {
        final ContentPage result = contentPageResource.create(contentPage)
                .execute();
        return result;
    }

    public static Boolean updateContentPage(ContentPage contentPage) {
        final Boolean result = contentPageResource.update(contentPage, contentPage.getPageId())
                .execute();
        return result;
    }

    public static List<ContentArticleVersion> getChildArticleVersions(long folderId) {
        return contentFolderResource
                .nestedResource(folderId, "contentArticleVersions", ContentArticleVersion.TYPES)
                .list()
                .withCache(CacheName.CONTENT)
                .execute();
    }

    public static ContentPage getContentPage(String title) {
        final ContentPage page = contentPageResource.list()
                .queryParam("title", title)
                .withCache(CacheName.CONTENT)
                .executeWithResult()
                .getOneIfExists();
        if (page == null) {
            throw new ContentNotFoundException("Content page does not exist: " + title);
        }
        return page;
    }

    public static ContentPage getContentPage(Long pageId) {
        final ContentPage page = contentPageResource.get(pageId).execute();
        if (page == null) {
            throw new ContentNotFoundException("Content page does not exist: " + pageId);
        }
        return page;
    }

    public static ContentPage getContentPageByContentArticleId(Long contentArticleId) {
        try {
            final ContentPage page = contentPageResource
                    .service("getByContentArticleId", ContentPage.TYPES.getEntityType())
                    .queryParam("contentArticleId", contentArticleId).getChecked();
            return page;
        }catch (EntityNotFoundException enfe){

        }
        return null;
    }

    public static List<ContentPage> getContentPages(String title) {
        final List<ContentPage> page = contentPageResource.list()
                .queryParam("title", title)
                .execute();
        if (page == null) {
            throw new ContentNotFoundException("Content page does not exist: " + title);
        }
        return page;
    }
}
