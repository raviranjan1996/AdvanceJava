package com.learning.example.guava_example;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Multiset<String> animals = HashMultiset.create();
		animals.add("cow");
		animals.add("lion");
		animals.add("lion");
		
		animals.forEach(e->System.out.println(e));
	}
}
