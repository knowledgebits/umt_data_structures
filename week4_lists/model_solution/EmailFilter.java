import java.util.LinkedList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EmailFilter {
    
    public static LinkedList<String> filterEmailsByDomain(LinkedList<String> emails, String domain) {
        LinkedList<String> filteredEmails = new LinkedList<>();
        
        for (String email : emails) {
            if (email.endsWith("@" + domain)) {
                filteredEmails.add(email);
            }
        }
        
        return filteredEmails;
    }
    
    public static int countAttachmentEmails(LinkedList<String> emails) {
        int count = 0;
        
        for (String email : emails) {
            if (email.contains("attachment") || email.contains("attached") || email.contains("enclosed")) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
    	
    	// Test method filterEmailsByDomain
        LinkedList<String> emails = new LinkedList<>();
        emails.add("john@example.com");
        emails.add("jane@example.com");
        emails.add("jim@example.org");
        emails.add("julia@example.com");
        
        LinkedList<String> filteredEmails = filterEmailsByDomain(emails, "example.com");
        
        System.out.println("Filtered emails:");
        for (String email : filteredEmails) {
            System.out.println(email);
        }
        
        // Test method countAttachmentEmails
        LinkedList<String> attachmentEmails = new LinkedList<>();
        attachmentEmails.add("Subject: Project Report - Attached");
        attachmentEmails.add("Body: Please find the attached project report.");
        attachmentEmails.add("Subject: Monthly Newsletter");
        attachmentEmails.add("Body: Check out our latest news and updates.");
        attachmentEmails.add("Subject: Resume - Enclosed");
        attachmentEmails.add("Body: Please find my enclosed resume for your review.");
        
        int count = countAttachmentEmails(attachmentEmails);
        
        System.out.println("Number of emails with attachments: " + count);
    }
}
