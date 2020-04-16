package com.loggar.websocket.chat;

public class ChatMessage {
	private String from;
	private String to;
	private String content;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessage [from=").append(from).append(", to=").append(to).append(", content=").append(content).append("]");
		return builder.toString();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
