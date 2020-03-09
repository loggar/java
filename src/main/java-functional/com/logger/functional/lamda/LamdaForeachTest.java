package com.logger.functional.lamda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LamdaForeachTest {
	@Test
	public void test() {
		List<Integer> v = Arrays.asList(4,5,6,7,8,9);
		
		/*
		 * internal loops : the loop logic has alrealdy been contained in the List class.
		 */
		v.forEach(i->System.out.println(i)); // and lamda expression.
		
		/*
		 * ê²°êµ­ Lamda Expression(->) ëŠ” í•œë²ˆë§Œ ì‚¬ìš©ë?˜ëŠ” inner class ì?˜ ì •ì?˜ë¥¼ ë‹¨ìˆœí™” í•˜ëŠ”ë?°ì—? ìžˆë‹¤
		 * Java Collection ì?˜ forEach() ëŠ” íŒŒë?¼ë¯¸í„°ë¡œ Consumer<T>ë¡œ ì„ ì–¸ ë?˜ì–´ ìžˆìœ¼ë©°, forEach() ì•ˆì—? ì •ì?˜ë?œ "->" ëŠ” ë‹¨ìˆœížˆ ê·¸ Consumer<T> ì?¸í„°íŽ˜ì?´ìŠ¤ë¥¼ ìž„ì‹œì •ì?˜ í•˜ëŠ” ê²ƒì?´ë‹¤. 
		 */
	}
	
}
