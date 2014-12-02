<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:fn="http://java.sun.com/jsp/jstl/functions"
          xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
          xmlns:spring="http://www.springframework.org/tags"
          xmlns:form="http://www.springframework.org/tags/form"
          xmlns:f="http://java.sun.com/jsf/core"
          xmlns:liferay-faces="http://liferay.com/tld/faces"
          xmlns:h="http://java.sun.com/jsf/html"
          xmlns:ui="http://java.sun.com/jsf/facelets"
          xmlns:ice="http://www.icesoft.com/icefaces/component"
          xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">
    <h1>Edit Preferences</h1>
    <portlet:actionURL var="updatePreferencesURL" />
    <style>
        .contactform-preferences input, .contactform-preferences textarea {
            width: 600px;
            font-size: 1.1em;
        }
        .contactform-preferences textarea {
            height: 200px;
        }
    </style>
    <form:form action="${updatePreferencesURL}" class="contactform-preferences" commandName="contactPreferences">
        <p>
            <strong>In messages you can use patterns like USER_NAME, USER_EMAIL, USER_MESSAGE as a placeholders for
                values entered by user.</strong>
        </p>
        <input type="hidden" name="action" value="savePreferences" />
        <fieldset>
            <p>
                Recipients, comma-separated:<br />
                <form:input path="recipients" />
            </p>
            <p>
                Message Format:<br />
                <form:textarea path="messageFormat" cols="30" rows="10" />
            </p>
            <p>
                Message Subject:<br />
                <form:input path="messageSubject" />
            </p>
            <p>
                Expand Link Text:<br />
                <form:input path="expandLinkText" />
            </p>

            <p>
                <input type="submit" value="Save" />
            </p>
        </fieldset>
    </form:form>
</jsp:root>