package com.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.Bayes.Bayes;
public class BayesTest {
	/**
	 * 读取测试元组
	 * @return 一条测试元组
	 * @throws IOException
	 */
	public ArrayList<String> readTestData() throws IOException{
		ArrayList<String> candAttr = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while (!(str = reader.readLine()).equals("")) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			while (tokenizer.hasMoreTokens()) {
				candAttr.add(tokenizer.nextToken());
			}
		}
		return candAttr;
	}
	
	/**
	 * 读取训练元组
	 * @return 训练元组集合
	 * @throws IOException
	 */
	public ArrayList<ArrayList<String>> readData() throws IOException {
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while (!(str = reader.readLine()).equals("")) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			ArrayList<String> s = new ArrayList<String>();
			while (tokenizer.hasMoreTokens()) {
				s.add(tokenizer.nextToken());
			}
			datas.add(s);
		}
		return datas;
	}
	public static void main(String[] args) {
		BayesTest tb = new BayesTest();
		ArrayList<ArrayList<String>> datas = null;
		ArrayList<String> testT = null;
		Bayes bayes = new Bayes();
		try {
			System.out.println("请输入训练数据");
			datas = tb.readData();
			while (true) {
				System.out.println("请输入测试元组");
				testT = tb.readTestData();
				String c = bayes.predictClass(datas, testT);
				System.out.println("The class is: " + c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
