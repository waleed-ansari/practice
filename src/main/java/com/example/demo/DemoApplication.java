package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {


	public static int month[];

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);

		//05:44

		List<Integer> list = new ArrayList<>();
		list.add(3);list.add(3);list.add(4);list.add(4);list.add(9);
		waiter(list,1);


	}

	public static void minimumBribes(List<Integer> q) {
		// Write your code here

		// 1, 2, 3, 4, 5, 6, 7, 8
		// 1, 2, 5, 3, 4, 6, 7, 8 -- 5
		// 1, 2, 5, 3, 7, 4, 6, 8 -- 7
		// 1, 2, 5, 3, 7, 8, 4, 6 -- 8
		// 1, 2, 5, 3, 7, 8, 6, 4 -- 6


		// 1, 2, 5, 3, 7, 8, 6, 4



		int bribe = 0;

		for(int i=0; i <q.size(); i++){

			if(i >= q.get(i)){
				int count = 0;
				for(int j=i+1; j<q.size(); j++){
					if(q.get(i) > q.get(j)){
						count++;
					}
					if(count > 2){
						System.out.println("Too chaotic");
						return;
					}
				}
				bribe += count;
				continue;
			}

			if(q.get(i) - (i + 1) > 2){
				System.out.println("Too chaotic");
				return;
			}else{

				bribe += q.get(i) - (i + 1);

			}

		}

		System.out.println(bribe);

	}

	public static String solution(String S) {
		// write your code in Java SE 8

		char[] cArr = S.toCharArray();
		String result = S.substring(0,S.length()-1);

		for(int i=0; i<S.length() - 1; i++){

			if(S.charAt(i) > S.charAt(i+1)){
					result = S.substring(0,i) + S.substring(i+1);
					break;
			}

		}

		return result;
	}

	public static List<String> bomberMan(int n, List<String> grid) {
		// Write your code here

		// 0 wait, 1 plants, 2 explode, 3 plants, 4 explode, 5 plant, 6 explode

		StringBuilder sb;

		for(int i=1; i<n; i++){

			for(int j=0; j<grid.size(); j++){

				if(i%2 != 0){
					grid.set(j,grid.get(j).replace('.','1'));
				}else{

					sb = new StringBuilder(grid.get(j));

					for(int k=0; k < grid.get(j).length(); k++){

						if(sb.charAt(k) == 'O'){

							sb.setCharAt(k,'.');

							if(k + 1 < sb.length()){
								if(sb.charAt(k+1) != 'O'){
								sb.setCharAt(k+1,'.');}
							}

							if(k - 1 >= 0){
								if(sb.charAt(k-1) != 'O'){
								sb.setCharAt(k-1,'.');}
							}

							grid.set(j,sb.toString());

							if(j + 1 < grid.size()){
								StringBuilder sd = new StringBuilder(grid.get(j+1));
								if(sd.charAt(k) != 'O'){
								sd.setCharAt(k,'.');
								grid.set(j+1,sd.toString());}
							}

							if(j - 1 >= 0){
								StringBuilder su = new StringBuilder(grid.get(j-1));
								if(su.charAt(k) != 'O'){
								su.setCharAt(k,'.');
								grid.set(j-1,su.toString());}
							}


						}

					}




				}

			}

			if(i%2 == 0){
				for(int l=0; l<grid.size(); l++){

					grid.set(l,grid.get(l).replace('1','O'));

				}
			}
		}

		for(int l=0; l<grid.size(); l++){

			grid.set(l,grid.get(l).replace('1','O'));

		}

		return grid;
	}

	public int solution(int[] A) {
		// write your code in Java SE 8

		Arrays.sort(A);

		for(int i=0; i<A.length -1 ; i++){
			if(A[i+1] - A[i] != 1){
				return A[i+1];
			}
		}

		return 3;
	}

	public int solution3(int[] A) {
		// write your code in Java SE 8

		Map<Integer,Integer> map = new HashMap();

		for(int i=0; i<A.length; i++){

			if(map.get(A[i]) == null){
				map.put(A[i],1);
			}else{
				map.remove(A[i]);
			}

		}

		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			return entry.getKey();
		}

		return 0;
	}

	public static int[] solution2(int[] A, int K) {
		// write your code in Java SE 8

		// 3, 8, 9, 7, 6, 3
		// 11

		int size = A.length;

		while (K > size){
			K -=size;
		}

		if(size == K){
			return A;
		}

		int[] b = new int[A.length];

		for(int i=0; i<A.length; i++){
			if(i+K < size){
			b[i+K] = A[i];
			}else{
				int ind = (i+K) - size;
				b[ind] = A[i];
			}
		}

		return b;
	}

	public static int solution1(int N) {
		// write your code in Java SE 8

		// 1000010001

		//
		String value = Integer.toBinaryString(N);
		int counter = 0;
		List<Integer> counters = new ArrayList<>();
		for (int i = 0; i < value.length(); i++) {
			char current = value.charAt(i);
			if (current == '0') {
				counter += 1;
			} else {
				counters.add(counter);
				counter = 0;
			}
		}
		return Collections.max(counters);
	}

	public static String highestValuePalindrome(String s, int n, int k) {
		// Write your code here

		//for(int)

		return "-1";

	}

	public static List<Integer> waiter(List<Integer> number, int q) {
		// Write your code here

		//3 3 4 4 9

		Collections.sort(number,Collections.reverseOrder());

		List<Integer> ans = new ArrayList<>();
		List<Integer> B = new ArrayList<>();

		int prime = 2;

		while (q > 0) {

			List<Integer> test = new ArrayList<>();
			test.addAll(number);

			for(Integer i : test){

				if (i % prime == 0) {
					ans.add(i);
					number.remove(i);
				}

			}
			Collections.sort(ans,Collections.reverseOrder());
			B.addAll(ans);
			prime = getPrimeNumber(prime);
			q--;
		}

		//Collections.sort(number,Collections.reverseOrder());

		B.addAll(number);


		return ans;
	}

	private static int getPrimeNumber(int input) {

		if(input == 2){
			return 3;
		}

		for(int i=input + 1; ;input++) {
			if(isPrime(input)){
				return i;
			}
		}

	}

	private static boolean isPrime(int input) {

		for(int i=2; i< Math.sqrt(input);i++){
			if(input % 2 == 0){
				return false;
			}
		}

		return true;
	}

	public static String isValid(String s) {
		// Write your code here

		//aabbcd

		Map<Character,Integer> map = new HashMap<>();

		for(char c: s.toCharArray()){
			if(map.get(c) == null){
				map.put(c,1);
			}else{
				Integer value = map.get(c);
				map.put(c,++value);
			}
		}

		boolean cdn = false;

		Integer previous = null;
		for(Map.Entry<Character,Integer> entry: map.entrySet()){
			if(previous == null){
				previous = entry.getValue();
				continue;
			}
			int current = entry.getValue();
			if(current == previous){
				continue;
			}else if(Math.abs(current - previous) == 1) {
				if (cdn) {
					return "NO";
				}
				cdn = true;
				continue;
			}else if(current - 1 == 0 || previous - 1 == 0){
				if (cdn) {
					return "NO";
				}
				cdn = true;
				continue;
			}else{
				return "NO";
			}
		}

		return "YES";
	}

	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here

		//100 100 50 40 40 20 10
		//5 25 50 120

		List<Integer> dR = ranked.stream().distinct().sorted().collect(Collectors.toList());

		List<Integer> list = new ArrayList<>();

		int lowCount = dR.size();

		int j=0;

		for(int i=0; i<player.size(); i++){

			if(player.get(i) < dR.get(0)){
				list.add(++lowCount);
				continue;
			}

			if(player.get(i) > dR.get(dR.size() - 1)){
				list.add(player.size() - i);
				continue;
			}

			for(j=0; j<dR.size()-1; j++){

				if(player.get(i) == dR.get(j)){
						list.add(dR.size() - j);
						break;
				}

				if(player.get(i) < dR.get(j)){
					list.add(dR.size() - j + 1);
					break;
				}

			}

		}

		return list;
	}

	public static long sumXor(long n) {
		// Write your code here

		long result = 0;

		if(n == 0){
			return 1;
		}

		while (n > 0) {
			if ((n & 1) == 0) {
				result++;
			}
			n >>= 1; // divides by 2
		}

		return 1L << result;
	}

	public static String isBalanced(String s) {
		// Write your code here
		// (, ), {, }, [, or ]

		String fb = "[{(";

		Stack<Character> stack = new Stack<>();

		char[] c = s.toCharArray();

		for(char ch : c){
			if(fb.contains(String.valueOf(ch))){
				stack.push(ch);
			}else{

				if(stack.size() == 0){
					return "NO";
				}

				if(ch == ']'){
					if(stack.pop() != '['){
						return "NO";
					}
				}else if(ch == '}'){
					if(stack.pop() != '{'){
						return "NO";
					}
				}if(ch == ')'){
					if(stack.pop() != '('){
						return "NO";
					}
				}
			}

		}

		return stack.size() == 0 ? "YES" : "NO";
	}

	public class 	SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
     }

	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
		// Write your code here

		// 1 -> 2 -> 3 -> 4 -> NULL




		return null;

	}

	public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
		// Write your code here

		List<Integer> ind = new ArrayList<>();

		for(int i=0; i<arr.size(); i++){

			for(int j=0; j<arr.size(); j++){

				if(i == j) continue;

				if(arr.get(i) + arr.get(j) == m){
					ind.add(i+1);
					if(ind.size() == 2){
						return ind;
					}
				}


			}

		}

		return ind;
	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		// Write your code here

		// 2, 6, 12

		List<Integer> count = new ArrayList<>();

		int result = 0;

		int sM = Collections.min(b);

		while (sM > 0){

			boolean innerChk = true;

			for(Integer i: a){
				if(sM % i != 0){
					innerChk = false;
				}
			}

			if(innerChk){
				count.add(sM);
			}

			sM /= 2;

		}

		for(Integer i: count){

			boolean innerChk = true;

			for(int j=0; j< a.size(); j++){

				if(i % a.get(j) !=0){
					innerChk = false;
					break;
				}

			}

			if(innerChk){
				result ++;
			}
		}


		return result;


/*
		int fM = Collections.max(a);
		int count = 0;

		for(Integer i: a){
			if(fM % i != 0){
				return count;
			}
		}

		for(Integer i: b){

			if(i % fM != 0){
				return count;
			}
		}

		count++;

		boolean chk = true;

		while (chk){
			fM *= 2;
			for(Integer i: b){
				if(i % fM != 0){
					return count;
				}
			}
			count++;
		}*/

		//return 0;
	}

	public static int palindromeIndex(String s) {

		int fI = 0;
		int sI = 0;
		boolean chk = true;

		for(int i=0; i<s.length() / 2; i++){

			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				fI = i;
				sI = s.length() - 1 - i;
				chk = false;
				break;
			}

		}

		if(chk){
			return -1;
		}

		if(p(s,fI+1,sI)){
			return fI;
		}else if(p(s,fI,sI-1)){
			return sI;
		}else{
			return -1;
		}



	/*	if(p(s)){
			return -1;
		}

		StringBuilder sb = new StringBuilder(s);

		for(int i=0; i<s.length(); i++){

			sb.deleteCharAt(i);
			if(p(sb.toString())){
				return i;
			}
			sb.insert(i,s.charAt(i));
		}
*/


	}

	private static boolean p(String s, int startIndex, int endIndex){

		for(int i=startIndex; i<endIndex; i++){
			if(s.charAt(i) != s.charAt(endIndex)){
				return false;
			}
			endIndex--;
		}

		return true;
	}

	public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
		storeMonth();

		int result = 0;

		while(true) {
			int x = d1;
			x = x * 100 + m1;
			x = x * 10000 + y1; // 1st line
			if(x % 4 == 0 || x % 7 == 0) { // 2nd line
				result = result + 1;
			}
			if(d1 == d2 && m1 == m2 && y1 == y2) {
				break;
			}
			updateLeapYear(y1);
			d1 = d1 + 1;
			if(d1 > month[m1]) {
				m1 = m1 + 1;
				d1 = 1;
				if(m1 > 12) {
					y1 =  y1 + 1;
					m1 = 1; // 3rd line
				}
			}
		}
		return result;
	}

	public static void updateLeapYear(int year) {
		if(year % 400 == 0) {
			month[2] = 29;
		} else if(year % 100 == 0) {
			month[2] = 28;
		} else if(year % 4 == 0) {
			month[2] = 29;
		} else {
			month[2] = 28;
		}
	}

	public static void storeMonth() {
		month[1] = 31;
		month[2] = 28;
		month[3] = 31;
		month[4] = 30;
		month[5] = 31;
		month[6] = 30;
		month[7] = 31;
		month[8] = 31;
		month[9] = 30;
		month[10] = 31;
		month[11] = 30;
		month[12] = 31;
	}

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		// Write your code here

		List<List<Integer>> list = new ArrayList<>();
		int lastAnswer = 0;
		List<Integer> result = new ArrayList<>();

		for(int i=0; i<n; i++){
			list.add(new ArrayList<>());
		}

		for(int i=0; i<queries.size(); i++){

			List<Integer> query = queries.get(i);

			if(query.get(0) == 1){

					int ind = (query.get(1) ^ lastAnswer) % n;
					list.get(ind).add(query.get(2));

			}else{

				int ind = (query.get(1) ^ lastAnswer) % n;
				lastAnswer = list.get(ind).get(query.get(2) % list.get(ind).size());
				result.add(lastAnswer);
			}


		}


		return result;
	}

	public static int towerBreakers(int n, int m) {
		// Write your code here

		if(m == 1){
			return 2;
		}else if(n%2 == 0){
			return 2;
		}else{
			return 1;
		}
	}

	public static String counterGame(long n) {
		// Write your code here

		int step = 0;

		while (n > 1) {

			if ((n & (n - 1)) == 0) {
				n /= 2;
			} else {

				long temp = n;
				if (n % 2 == 0) {
					temp = n - 1;
				}
				long power = (long) (Math.log(temp) / Math.log(2));
				long result = (long) Math.pow(2, power);

				n -= result;

			}

			step++;

		}


		return step % 2 == 0 ? "Richard" : "Louise";
	}

	public static int superDigit(String n, int k) {

		// 18:16 -- 18:40

		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(superDigit("861568688536788",100000));

		// Write your code here

		// Calculate n then multiply by k - First super Digit
		// Then sum again until singe digit

		// Convertn Str to Int
		// Calculate Int sum
		// sum * k


		//int input = Integer.parseInt(n);

		char[] cArr = n.toCharArray();

		BigInteger sumBig = BigInteger.ZERO;

		for(int i=0; i< cArr.length; i++){

			sumBig = sumBig.add(new BigInteger(String.valueOf(cArr[i])));

		}

		sumBig = sumBig.multiply(new BigInteger(String.valueOf(k)));

		//int sum = sumBig.intValue();

		while (sumBig.toString().length() > 1){

			BigInteger newBigSum = BigInteger.ZERO;

			while (sumBig.compareTo(BigInteger.ZERO) > 0){
				//newSum += sum % 10 ;
				newBigSum = newBigSum.add(sumBig.mod(BigInteger.TEN));
				//sum /= 10;
				sumBig = sumBig.divide(BigInteger.TEN);
			}

			sumBig = newBigSum;

		}

		return sumBig.intValue();
	}

	public static String balancedSums(List<Integer> arr) {
		// Write your code here

		//1, 2, 3, 4, 6

		// sum = 16

		// 17:41 -- 18:15

		/*List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);list.add(3);

		System.out.println(balancedSums(list));*/

		if(arr.size() == 1) return "YES";

		Integer totalSum = arr.stream()
				.mapToInt(Integer::intValue)
				.sum();

		int leftSum = 0;

		for(int i=0; i<arr.size() - 1; i++){

			int sum = totalSum;

			if(i - 1 >= 0){
				leftSum += arr.get(i - 1);
			}

			sum = sum - leftSum - arr.get(i);

			if(leftSum == sum)
				return "YES";


		}

		return "NO";
	}

	public static String gridChallenge(List<String> grid) {
		// Write your code here

		// 17:15 -- 17:40

		/*List<String> list = new ArrayList<>();
		list.add("abc");list.add("hjk");list.add("mpq");list.add("rtv");

		System.out.println(gridChallenge(list));*/

		int[] size = new int[grid.get(0).length()];

		for(int i=0; i<grid.size(); i++){

			char[] cArr = grid.get(i).toCharArray();
			int[] iArr = new int[cArr.length];



			for(int j=0; j < cArr.length; j++){
				iArr[j] = cArr[j];
			}

			Arrays.sort(iArr);

			if(size[0] == 0){
				for(int k=0; k<iArr.length; k++){

					size[k] = iArr[k];

				}
			}else{

				for(int k=0; k<iArr.length; k++){

					if(size[k] > iArr[k]) return "NO";
					else size[k] = iArr[k];

				}


			}





		}


		return "YES";
	}

	public static int maxMin(int k, List<Integer> arr) {
		// Write your code here

		//16:33 -- 17:11
/*
		List<Integer> list = new ArrayList<>();
		list.add(4504);list.add(1520);list.add(5857);list.add(4094);list.add(4157);
		list.add(3902);list.add(822);list.add(6643);list.add(2422);list.add(7288);
		list.add(8245);list.add(9948);list.add(2822);list.add(1784);list.add(7802);
		list.add(3142);list.add(9739);list.add(5629);list.add(5413);list.add(7232);
		System.out.println(maxMin(5,list));*/

		int result = Integer.MAX_VALUE;

		List<Integer> list = arr.stream().sorted().collect(Collectors.toList());

		for(int i=0; i<list.size() - k + 1; i++){

			result = Math.min(  list.get(i+k-1) - list.get(i), result);

		}

	/*	for(int i=0; i<list.size(); i+=k-1){

			if(i + k > list.size()) break;

			List<Integer> subList = list.subList(i,i+k);

			result = Math.min(Collections.max(subList) - Collections.min(subList), result);


		}*/

		return result;
	}

	public static String caesarCipher(String s, int k) {

		// System.out.println(caesarCipher("www.abc.xy",87));
		// Write your code here

		while (k > 26){
			k -= 26;
		}

		char[] cArr = s.toCharArray();
		char[] output = new char[s.length()];

		for(int i=0;i<cArr.length; i++){

			int asci = cArr[i];

			if(asci >= 65 && asci <= 90){

				if(asci + k > 90){

					output[i] = (char) (65 + (asci + k - 90) - 1);

					//int diff = (65 + (asci + k - 90) - 1);


				}else{
					output[i] = (char) (asci + k);
				}

			}


			else if(asci >= 97 && asci <= 122){

				if(asci + k > 122){
					output[i] = (char) (97 + (asci + k - 122) - 1);

				/*	int diff = (asci + k) - 122;

					while (diff > 25){
						diff -= 25;
					}

					output[i] = (char) (97 + (diff) - 1);*/

				}else{
					output[i] = (char) (asci + k);
				}

			}

			else{
				output[i] = cArr[i] ;
			}

		}

		return String.valueOf(output);
	}

	public static int pageCount(int n, int p) {

		// 1
		// 1 , 23
		// 1 , 2
		// 1 , 23 , 4
		// 1 , 23 , 45, 67
		// 1 , 23 , 45, 6
		// 1 , 23 , 45
		// 1 , 23 , 45 , 6
		// 1 , 23 , 45 , 67 , 89
		// 1 , 23 , 45 , 67 , 89 , 1011 , 1213

		if(p == 1){
			return 0;
		}

		if(p == n){
			return 0;
		}

		if(p == n-1 && (n-1) % 2 == 0){
			return 0;
		}

		if(p == n-1 && (n-1) % 2 != 0){
			return 1;
		}

		if(n - p > p){
			return p / 2;
		}else{

			return (n - p) / 2;

		}




		/*if(n - p > p){

			if(p == 1){
				return 0;
			}else{
				return p / 2;
			}

		}else{

			if(n == p){
				return 0;
			}else if(n-1 == p && n-1 % 2 != 0)
			{
				return 0;
			} else if(n-1 == p && n-1 % 2 == 0){
				return 1;
			}
			else{
				return (n-p) / 2;
			}


		}*/
	}

	public static void findZigZagSequence(int [] a, int n){


		//findZigZagSequence(new int[]{1,2,3,4,5,6,7}, 7);

		Arrays.sort(a);
		int mid = (n)/2;
		int temp = a[mid];
		a[mid] = a[n - 1];
		a[n - 1] = temp;

		int st = mid + 1;
		int ed = n - 2;
		while(st <= ed){
			temp = a[st];
			a[st] = a[ed];
			a[ed] = temp;
			st = st + 1;
			ed = ed - 1;
		}
		for(int i = 0; i < n; i++){
			if(i > 0) System.out.print(" ");
			System.out.print(a[i]);
		}
		System.out.println();
	}


	public static int sockMerchant(int n, List<Integer> ar) {

		//16:32 -- 16:38
		// Write your code here

		// loop over list
		// insert into map with key
		// if exists -- increase the pair count and remove from map

		Map<Integer,Integer> map = new HashMap<>();
		int pair = 0;

		for(int i=0; i<n ; i++){

			if(map.get(ar.get(i)) == null){
				map.put(ar.get(i),1);
			}else{
				map.remove(ar.get(i));
				pair++;
			}
		}

		return pair;
	}

	public static int flippingMatrix(List<List<Integer>> matrix) {

		int n = matrix.size();

		int sum = 0;

		for(int i=0; i < n/2; i++){

			for(int j=0 ; j < n/2; j++){

				int p1 = matrix.get(i).get(j);
				int p2 = matrix.get(i).get(n - j - 1);
				int p3 = matrix.get(n - i - 1).get(j);
				int p4 = matrix.get(n - i - 1).get(n - j -1);

				sum += Math.max(Math.max(p1,p2),Math.max(p3,p4));


				//sum += max(a[i][j], a[i][n - j - 1], a[n - i - 1][j], a[n - i - 1][n - j - 1]);
				//00, 03,
			}

		}


		return sum;
	}

	public static int findMedian(List<Integer> arr) {
		// Write your code here

	/*	List<Integer> list = new ArrayList<>();
		list.add(0);list.add(1);list.add(2);list.add(4);list.add(6);list.add(5);list.add(3);

		System.out.println(findMedian(list));*/

		List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());

		return sorted.get(sorted.size() / 2 + 1);
	}

	public static String stringsXOR(String s, String t) {
		String res = new String("");
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == t.charAt(i))
				res += "0";
			else
				res += "1";
		}

		return res;
	}

	public static int birthday(List<Integer> s, int d, int m) {

		// 13:03 - 13:24
/*
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(1);list.add(3);list.add(2);
		System.out.println(birthday(list,3,2));*/

		// Write your code here

		//The length of the segment matches Ron's birth month, and,
		//The sum of the integers on the squares is equal to his birth day.

		// Loop over Array
		// If current element == d

		int count = 0;

		for(int i=0; i<s.size(); i++){

			int sum = 0;

			if(i+m > s.size()){
				break;
			}

			for(int j=i; j<i+m; j++){

				sum += s.get(j);

			}

			if(sum == d){
				count++;
			}

		}

		return count;
	}

	public static String twoArrays(int k, List<Integer> A, List<Integer> B) {

		// Frequency to sort

		// 19:20 -- 19:41

		// Write your code here

		List<Integer> aPerm = A.stream().sorted().collect(Collectors.toList());
		List<Integer> bPerm = B.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

		for(int i=0; i< aPerm.size(); i++){
			if(aPerm.get(i) + bPerm.get(i) < k){
				return "NO";
			}
		}



		return "YES";
	}

	public static List<Integer> countingSort(List<Integer> arr) {

/*
		List<Integer> input = new ArrayList<>();
		input.add(1);input.add(1);input.add(3);input.add(2);input.add(1);

		countingSort(input).forEach(w -> System.out.println(w));
*/

		// Write your code here

		// Create Frequency array of count 10
		// loop over input array and inc the count

		int[] freArr = new int[100];

		for(int i=0; i<arr.size(); i++){
			if(freArr[arr.get(i)] == 0){
				freArr[arr.get(i)] = 1;
			}else{
				freArr[arr.get(i)] = freArr[arr.get(i)] + 1;
			}
		}

		return Arrays.stream(freArr).boxed().collect(Collectors.toList());

	}

	public static int diagonalDifference(List<List<Integer>> arr) {


	/*	List<List<Integer>> arr = new ArrayList<>();

		List<Integer> innerList1 = new ArrayList<>();
		innerList1.add(1);innerList1.add(2);innerList1.add(3);

		List<Integer> innerList2 = new ArrayList<>();
		innerList2.add(4);innerList2.add(5);innerList2.add(6);

		List<Integer> innerList3 = new ArrayList<>();
		innerList3.add(9);innerList3.add(8);innerList3.add(9);

		arr.add(innerList1); arr.add(innerList2); arr.add(innerList3);

		System.out.println(diagonalDifference(arr));*/

		// Write your code here

		// Loop over first array
		// Count both diagnal in parralel

		int firstD = 0, secondD = 0;
		int ind = 0;

		for(List<Integer> innerList : arr){
			firstD += innerList.get(ind);
			secondD += innerList.get(innerList.size() - ind - 1);
			ind++;
		}


		return Math.abs(firstD - secondD);
	}

	public static long flippingBits(long n) {


		// 18:33 -- 18:51
/*
		System.out.println(flippingBits(9l));*/
		// Write your code here

		// Convert long to Binary String
		// Loop over binary strip and flip
		// Convert Binary String to number and return back

		String input = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0');

		char[] cArr = input.toCharArray();

		for(int i=0; i<cArr.length; i++){
			 if(cArr[i] == '0'){
				 cArr[i] = '1';
			}else{
				 cArr[i] = '0';
			 }
		}

		return Long.parseLong(String.valueOf(cArr),2);

	}

	public static int lonelyinteger(List<Integer> a) {
/*
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(3);list.add(2);list.add(1);

		System.out.println(lonelyinteger(list));*/
		// Create a map with key and count - if exists increase count, else delete
		// return key, whose count is 1 - Should be one only

		Map<Integer,Integer> map = new HashMap<>();

		for(Integer input: a){
			if(map.get(input) == null){
				map.put(input,1);
			}else{
				map.remove(input);
			}
		}

		return map.entrySet().stream().findFirst().get().getKey();

	}

	public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

		// 18:11 -- 18:21

/*
		List<String> strings = new ArrayList<>();
		strings.add("def");strings.add("de");strings.add("fgh");

		List<String> queries = new ArrayList<>();
		queries.add("de");queries.add("lmn");queries.add("fgh");

		matchingStrings(strings,queries).forEach(w -> System.out.println(w));

*/

		// Write your code here

		// loop each query over strings

		List<Integer> resultCount = new ArrayList<>();

		for(String input: queries){
			resultCount.add((int) strings.stream().filter(w -> w.equalsIgnoreCase(input)).count());
		}


		return resultCount;
	}

	public static boolean isAnagram(String a, String b){

		//17:24 -- //17:40

	/*	System.out.println(isAnagram("flow", "wolf"));
		System.out.println(isAnagram("pat", "tap"));
		System.out.println(isAnagram("night", "thing"));
		System.out.println(isAnagram("slip", "lips"));
		System.out.println(isAnagram("boss", "sobs"));
		System.out.println(isAnagram("was", "saw"));
		System.out.println(isAnagram("bosso", "bossb"));
		System.out.println(isAnagram("slipl", "lipsi"));
		System.out.println(isAnagram("SILENT", "LISTEN"));
		System.out.println(isAnagram("SILENT", "LISTEN"));*/

		// LISTEN -- SILENT
		// Size not same return false
		// Loop a over b

		if(a.length() != b.length()){
			return false;
		}

		char[] aChar = a.toLowerCase().toCharArray();
		char[] bChar = b.toLowerCase().toCharArray();

		Arrays.sort(aChar); Arrays.sort(bChar);

		return String.valueOf(aChar).equalsIgnoreCase(String.valueOf(bChar)) ? true : false;

	}

	public static boolean isAnagramOldSchool(String a, String b){

		// LISTEN -- SILENT
		// Size not same return false
		// Loop a over b

		if(a.length() != b.length()){
			return false;
		}

		char[] aChar = a.toLowerCase().toCharArray();
		char[] bChar = b.toLowerCase().toCharArray();
		int count = 0;

		for(int i=0; i< a.length(); i++){

			for(int j=0; j<b.length(); j++){
				if(aChar[i] == bChar[j]){
					bChar[j] = ' ';
					count++;
					break;
				}
			}
		}

		return count == a.length() ? true : false;

	}

	public static String timeConversion(String s) {

		//17:07 -- //17:23

/*
		String time = "12:01:01AM";
		// Output = "12:01:01;
		System.out.println(timeConversion(time));*/

		String[] strArr = s.split(":");
		boolean isAM = strArr[2].substring(2,4).equalsIgnoreCase("AM");
		strArr[2] = strArr[2].substring(0,2);

		if(isAM){

			if(strArr[0].equalsIgnoreCase("12")){
				strArr[0] = "00";
			}

		}else{

			if(!strArr[0].equalsIgnoreCase("12")){
				strArr[0] = String.valueOf(Integer.parseInt(strArr[0]) + 12);
			}

		}

		return strArr[0] + ":" + strArr[1] + ":" + strArr[2];
	}

	public static void miniMaxSum(List<Integer> arr) {
/*
		List<Integer> arr = new ArrayList<>();
		arr.add(256741038);arr.add(623958417);arr.add(467905213);arr.add(714532089);arr.add(938071625);
		miniMaxSum(arr);*/

		List<Integer> sortedArr = arr.stream().sorted().collect(Collectors.toList());

		BigInteger sum = new BigInteger("0");

		for(int i=0; i<sortedArr.size(); i++){

			sum = sum.add(new BigInteger(sortedArr.get(i).toString()));

		}

		BigInteger minSum = sum.subtract(new BigInteger(sortedArr.get(4).toString())),
				maxSum = sum.subtract(new BigInteger(sortedArr.get(0).toString()));

		System.out.println(minSum + " " + maxSum);

	}

	public static void plusMinus(List<Integer> arr){

//		List<Integer> arr = new ArrayList<>();
//		arr.add(1);
//		arr.add(1);
//		arr.add(0);
//		arr.add(-1);
//		arr.add(-1);
//		arr.add(-1);
//		arr.add(-1);

		//plusMinus(arr);

		double pos = 0, neg = 0, zero = 0;

		for (Integer integer : arr) {

			if (integer > 0) {
				pos++;
			} else if (integer < 0) {
				neg++;
			} else {
				zero++;
			}
		}

		System.out.println(String.format("%.6f", pos / arr.size()));
		System.out.println(String.format("%.6f", neg / arr.size()));
		System.out.println(String.format("%.6f",zero / arr.size()));

	}

	public static String pangrams(String s) {

		//String sentence = "The quick brown fox jumps over the lazy dog";
		//System.out.println(pangrams(sentence));

		boolean isPangram;

		Map<String,Integer> asciMap = new HashMap<>();

		for(int i=65 ; i<91; i++){
			asciMap.put(Character.toString((char)i), i);
		}

		char[] charArr = s.toUpperCase().toCharArray();

		for(int i=0; i< charArr.length; i++){

			if(asciMap.size() == 0){
				break;
			}

			String key = String.valueOf(charArr[i]);

			if(asciMap.get(key) != null){
				asciMap.remove(key);
			}

		}

		isPangram = asciMap.size() == 0;

		return isPangram ? "pangram" : "not pangram";
	}

	public static int activityNotifications(List<Integer> expenditure, int d) {
		// Write your code here

		if(d < expenditure.size()) {

			int startInd = 0;
			List<Integer> pastData = new ArrayList<>();

			for (int i = startInd; i < d; i += d) {
				pastData.add(i);
			}

			pastData.stream().sorted();

		}

		return 0;
	}
}
