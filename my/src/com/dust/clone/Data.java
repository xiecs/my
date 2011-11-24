package com.dust.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Data implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3854604562528438882L;

	public String id;

	public int a;

	private Data1 data1 = new Data1();

	/**
	 * 浅拷贝,值类型拷贝值，引用类型拷贝引用
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 深拷贝，通过序列化还原原有对象，断开引用
	 * 
	 */
	public Object deepClone() {
		try {
			// write to stream
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this); // read from stream
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (oi.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Data(String id, int a) {
		super();
		this.id = id;
		this.a = a;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Data1 getData1() {
		return data1;
	}

	public void setData1(Data1 data1) {
		this.data1 = data1;
	}

}
