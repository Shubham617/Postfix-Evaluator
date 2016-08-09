package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
LLNode<T> head;
int size=0;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			T e=head.getData();
			head=head.getNext();
		size--;
		return e;
		}
		else throw new StackUnderflowException("pop from empty stack");
		}
		

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(!isEmpty())
		return head.getData();
		else throw new StackUnderflowException("top of empty stack");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head==null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		LLNode<T> newNode = new LLNode<T>(elem);
		newNode.setNext(head);
		head = newNode;
		size++;
	}

}
