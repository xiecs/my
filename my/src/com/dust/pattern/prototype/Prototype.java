package com.dust.pattern.prototype;

/**
 * 原型模式
 * 
 * 用原型实例指定创建对象的种类,并且通过拷贝这些原型创建新的对象.
 * Prototype模式允许一个对象再创建另外一个可定制的对象，根本无需知道任何如何创建的细节。 工作原理是:通过将一个原型对象传给那个要发动创建的对象，
 * 这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建。
 * 
 * 
 * 你如果要生成一大批很相像的类的实例时，省得每次去做重复的赋值工作。
 * 再举 个例子，如果你有一个类A,它有十个成员变量，现在你打算生成100个A的实例，而这些实例的变量值大部分相同（比如说七个相同），只有一小部分不一样 （比如说三个），那么如果没有Prototype,那么你就得每次New一个A的对像，然后赋值，这样，你要重复100次同样的七个变量的赋值工作，显 然，这样很麻烦。
 * 现在你有了原型，那么问题就简单了，你只要生成一个A的实例，再通过clone来生成其它的实例，然后再一一修改其它实例不同的地方。
 */
public abstract class Prototype implements Cloneable {

	private String id;

	public Prototype(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public abstract Prototype clone();

}
