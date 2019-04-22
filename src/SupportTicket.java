


public class SupportTicket implements Comparable<SupportTicket> {
  
  private String message;
  
  /**
   * 
   * @param message is information about what needs support
   * @throws NullPointerException
   */
  public SupportTicket(String message){
    
    if(message == null)
      throw new NullPointerException("Error. Message is null.");
    
    this.message = message;    
  }
  /**
   * @return the message.
   */
  public String toString() {
    return message;
  }
  
  /**
   * compares two tickets
   * @return returns a positive integer if object is smaller than 
   */
  public int compareTo(SupportTicket ticket) {
    
    
    int dif = this.toString().length() - ticket.toString().length();
    
  //runtime polymorphism
    if(dif == 0)
      dif = this.toString().compareTo(ticket.toString());
      
    
    
    return dif;
  }
  
  

}
