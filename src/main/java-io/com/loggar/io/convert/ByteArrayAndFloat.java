package com.loggar.io.convert;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.ByteBuffer;

import org.junit.jupiter.api.Test;

public class ByteArrayAndFloat {
	public static byte[] floatToByteArray(float value) {
		int intBits = Float.floatToIntBits(value);
		return new byte[] { (byte) (intBits >> 24), (byte) (intBits >> 16), (byte) (intBits >> 8), (byte) (intBits) };
	}

	public static byte[] floatToByteArrayWithNioByteBuffer(float value) {
		return ByteBuffer.allocate(4).putFloat(value).array();
	}

	public static float byteArrayToFloat(byte[] bytes) {
		int intBits = bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
		return Float.intBitsToFloat(intBits);
	}

	public static float byteArrayToFloatWithNioByteBuffer(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getFloat();
	}

	@Test
	public void givenAFloat_thenConvertToByteArray() {
		assertArrayEquals(new byte[] { 63, -116, -52, -51 }, floatToByteArray(1.1f));
		assertArrayEquals(new byte[] { 63, -116, -52, -51 }, floatToByteArrayWithNioByteBuffer(1.1f));
	}

	@Test
	public void givenAByteArray_thenConvertToFloat() {
		assertEquals(1.1f, byteArrayToFloat(new byte[] { 63, -116, -52, -51 }));
		assertEquals(1.1f, byteArrayToFloatWithNioByteBuffer(new byte[] { 63, -116, -52, -51 }));
	}
}
