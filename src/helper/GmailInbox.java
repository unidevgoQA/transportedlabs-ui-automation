package helper;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.regex.*;

public class GmailInbox {

    public static void main(String[] args) {

//        GmailInbox gmail = new GmailInbox();
//        gmail.readOTP();

    }

    public static String readOTP() {

        Properties props = new Properties();

        try {
            props.load(Files.newInputStream(new File("src/helper/smtp.properties").toPath()));
            Session session = Session.getDefaultInstance(props, null);

            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "ss.unidev@gmail.com", "5946644S");

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();

            System.out.println("Total Messages:- " + messageCount);
            Message[] messages = inbox.getMessages();
            Collections.reverse(Arrays.asList(messages));
            System.out.println("------------------------------");

            String lastMessage = messages[0].getContent().toString();
            System.out.println(lastMessage);

            //match 4 digits OTP with regular expression
            Pattern pattern = Pattern.compile("\\d{4}");
            Matcher matcher = pattern.matcher(lastMessage);

            if (matcher.find()) {
                return matcher.group();
            }


            inbox.close(true);
            store.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}