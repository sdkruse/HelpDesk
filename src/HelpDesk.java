import java.lang.Math.*;

public class HelpDesk implements HelpDeskInterface {

  protected SupportTicket[] array; // zero-indexed max-heap
  protected int size;

  public HelpDesk(int capacity) {
    
    size = 0;
    array = new SupportTicket[capacity];

  }

  // Given an index into the heap array, this method returns that index's parent index.

  protected static int parentOf(int index) {
    if(index % 2 == 0)
      return (index-2) / 2;
    
    return (index-1) / 2;

  }
  // Given an index into the heap array, this method returns that index's left child index.

  protected static int leftChildOf(int index) {
    return index * 2 + 1;
  }

  // Given an index into the heap array, this method returns that index's right child index.

  protected static int rightChildOf(int index) {
    return index * 2 + 2;
  }

  // Given two indexes into the heap array, this method swaps the SupportTickets at those indexes.

  protected void swap(int indexA, int indexB) {
    SupportTicket a = array[indexA];
    SupportTicket b = array[indexB];
    array[indexA] = b;
    array[indexB] = a;
  }
  // Given an index into the heap array, this method recursively swaps any SupportTickets
  // necessary to enforce the heap's order property between this index and the heap's root.

  protected void propagateUp(int index) {
    if (index != 0) {

      if (array[index].compareTo(array[parentOf(index)]) > 0) {
        swap(index, parentOf(index));
        propagateUp(parentOf(index));

      }
    }

  }

  /**
   * Given an index into the heap array, this method recursively swaps any SupportTickets necessary to
   * enforce the heap's order property between this index and it's children.
   * 
   * @param index
   */
  protected void propagateDown(int index) {

    if (size > leftChildOf(index)) {

      if (size > leftChildOf(index) && size <= rightChildOf(index)) {
        // if left child is bigger, swap them.
        if (array[leftChildOf(index)].compareTo(array[index]) > 0) {
          swap(index, leftChildOf(index));
          propagateDown(leftChildOf(index));
        }

      } else if (array[leftChildOf(index)]
          .compareTo(array[rightChildOf(index)]) < 0) {
        swap(index, rightChildOf(index));
        propagateDown(rightChildOf(index));
      } else if (array[leftChildOf(index)]
          .compareTo(array[rightChildOf(index)]) > 0) {
        swap(index, leftChildOf(index));
        propagateDown(leftChildOf(index));
      }
    }
  }



  /**
   * Creates and adds a new SupportTicket to this HelpDesk.
   * 
   * @param message names the client and describes their need for support.
   * @throws NullPointerException      when the String message argument is null.
   * @throws IndexOutOfBoundsException when called on HelpDesk with a full array an add method
   */
  @Override
  public void createNewTicket(String message) {
    
    if(message == null)
      throw new NullPointerException("Error. Null message.");
    
    if(size == array.length)
      throw new IndexOutOfBoundsException("Cannot add ticket, helpdesk is full.");
    
    SupportTicket toAdd = new SupportTicket(message);
    array[size] = toAdd;
    propagateUp(size);
    size++;
  }

  /**
   * Returns the message within this HelpDesk that has the highest priority. This method does not
   * change the state of this HelpDesk.
   * 
   * @return the message within the highest priority SupportTicket.
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets. a peek method
   */
  @Override
  public String checkNextTicket() {
    if(size == 0)
      throw new IllegalStateException("No support tickets.");
    
    return array[0].toString();
  }

  /**
   * Returns and removes the message within this HelpDesk that has the highest priority.
   * 
   * @return the message within the highest priority SupportTicket (prior to its removal).
   * @throws IllegalStateException when called on a HelpDesk with zero SupportTickets.
   * 
   *                               a remove method
   */
  @Override
  public String closeNextTicket() {
    if(size == 0) 
      throw new IllegalStateException("Error: no support tickets to close");
  
  String priority = array[0].toString();
  array[0] = array[size-1];
  array[size-1] = null;
  size--;
  propagateDown(0);
  return priority;
  }

}
