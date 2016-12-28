/**
 * 
 */

/**
 * @author Administrator
 *
 */
public abstract class Duck {
	QuackBehavior quackBehavior;

	public Duck() {

	}

	public void performQuack() {
		quackBehavior.quack();
	}
}
