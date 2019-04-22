
public class HelpDeskTestSuite {

  
  private static boolean testSupportTicket() {
    boolean pass = false;
    int passed = 0;
    
    SupportTicket ticket = new SupportTicket("Test");
    SupportTicket ticketOther = new SupportTicket("Test");
    SupportTicket anotherTicket = new SupportTicket("Another Test");
    
    String messageTest = ticket.toString();
    String messageTestTwo = anotherTicket.toString();
    
    if(messageTest.equals("Test"))
      passed++;
    
    if(ticket.compareTo(ticketOther) == 0)
      passed++;
    if(ticket.compareTo(anotherTicket) < 0)
      passed++;
      
      if(passed == 3)
        pass = true;
    
    
    
    
    
    return pass;
  }
  
  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    if(!testSupportTicket()) 
    System.out.println("Failed Support Ticket Test");
    

  }

}
