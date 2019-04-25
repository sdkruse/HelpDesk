
public class HelpDeskTestSuite {

  
  private static boolean testSupportTicket() {
    boolean pass = false;
    int passed = 0;
    
    SupportTicket ticket = new SupportTicket("Test");
    SupportTicket ticketOther = new SupportTicket("Test");
    SupportTicket aTicket = new SupportTicket("A");
    SupportTicket bTicket = new SupportTicket("B");
    SupportTicket anotherTicket = new SupportTicket("Another Test");
    
    String messageTest = ticket.toString();
    String messageTestTwo = ticketOther.toString();
    
    if(messageTest.equals(messageTestTwo))
      passed++;
    
    if(ticket.compareTo(ticketOther) == 0)
      passed++;
    if(ticket.compareTo(anotherTicket) < 0)
      passed++;
    if(aTicket.compareTo(bTicket) < 0)
      passed++;
      
      if(passed == 4)
        pass = true;
      
    return pass;
  }
  
  private static boolean testRemove() {
  boolean pass = false;
  
  HelpDesk myTestDesk = new HelpDesk(2);
  myTestDesk.createNewTicket("Boiler is overheating");
  
  myTestDesk.closeNextTicket();
  
  try {
    
    myTestDesk.closeNextTicket();
    
    
  }catch(IllegalStateException i) {
    pass = true;
  }
  return pass;
  }
  
  private static boolean testRelationships() {
    boolean pass = false;
    int testPassed = 0;
    HelpDesk desk = new HelpDesk(20);
    
    if(desk.leftChildOf(2) == 5)
      testPassed++;
    
    if(desk.rightChildOf(2) == 6)
      testPassed++;
    
    if(desk.parentOf(3) != 1)
      testPassed++;
    
    if(testPassed == 3)
      pass = true;
    
    return pass;
  }
  
  

  
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    if(!testSupportTicket()) 
    System.out.println("Failed Support Ticket Test");
    
    if(!testRemove()) 
    System.out.println("Failed remove Ticket Test");
    
    if(!testRelationships()) 
      System.out.println("Failed relationships test");
    
    if()
    
    

  }

}
