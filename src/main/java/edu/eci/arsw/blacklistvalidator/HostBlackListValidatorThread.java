package edu.eci.arsw.blacklistvalidator;


import java.util.LinkedList;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;


public class HostBlackListValidatorThread extends Thread{
	private int start;
	private int end;
	private int Count;
	private String ipAddress;
	private LinkedList<Integer> servers;
	
	public HostBlackListValidatorThread(int start, int end, String ipAddress) {
		this.start=start;
		this.end=end;
		this.Count=0;
		this.ipAddress=ipAddress;
		servers = new LinkedList<Integer>();	
	}

	public int getServersAmount() {
		return servers.size();
	}
	
	@Override
	public void run() {
		HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
		for (int i=start; i<=end; i++) {
			Count++;
			if (skds.isInBlackListServer(i, ipAddress)) {
				servers.add(i);
			}
		}
	}
	
	
	/** 
	 * Getters y Setters de todas las variables definidas
	 * @return
	 */
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public LinkedList<Integer> getServers() {
		return servers;
	}

	public void setServers(LinkedList<Integer> servers) {
		this.servers = servers;
	}
	
	

}
