package org.builder.BuilderDesignPattern;

import java.util.function.Consumer;

/**
 * @author Irfan Shaikh.
 *
 */
public class GenericBuilderPattern<T> {

	// To hold the instence.
	private T instance;

	/**
	 * The Constructor
	 * @param clazz
	 */
	public GenericBuilderPattern(Class<T> clazz) {
		try {
			this.instance = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param clazz
	 * @return new Instance.
	 */
	public static <T> GenericBuilderPattern<T> build(Class<T> clazz) {
		return new GenericBuilderPattern<>(clazz);
	}

	/**
	 * @return instance.
	 */
	public T get() {
		return instance;
	}

	/**
	 * @param setter
	 * @return this.
	 */
	public GenericBuilderPattern<T> with(Consumer<T> setter) {
		// to do..
		setter.accept(instance);
		return this;
	}

	public static void main(String[] args) {
		Person builder = GenericBuilderPattern.build(Person.class).with(sette -> sette.setAge(12)).get();
		System.out.println(builder);
	}
}
class Person {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
