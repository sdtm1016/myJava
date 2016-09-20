package net.socket.qqDemo.common;

import java.util.Set;

import net.socket.qqDemo.utils.SocketUtil;

public class ServerFriendsMessage extends Message {
	public ServerFriendsMessage(Set<String> friends) {
		super(SocketUtil.writeFriends(friends));
		setType(TYPE_SERVER_RSPONDS);
	}

}
