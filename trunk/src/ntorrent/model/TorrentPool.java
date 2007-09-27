/**
 *   nTorrent - A GUI client to administer a rtorrent process 
 *   over a network connection.
 *   
 *   Copyright (C) 2007  Kim Eik
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ntorrent.model;

import ntorrent.Controller;
import ntorrent.io.xmlrpc.Rpc;
import ntorrent.io.xmlrpc.RpcCallback;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;

public class TorrentPool extends RpcCallback{
	TorrentSet torrents = new TorrentSet();
	private TorrentSet viewset = new TorrentSet();
	String view = "main";
	Rpc rpc;
	TorrentTableModel table;
	long rateUp,rateDown;

	TorrentPool(){}

	public TorrentPool(Rpc r, TorrentTableModel t) throws XmlRpcException{
		rpc = r;
		table = t;
		rateUp = rateDown = 0;
	}	
	
	
	public String getView() {
		return view;
	}
	
	public TorrentTableModel getTable() {
		return table;
	}
	
	//From viewset
	public int size(){ return viewset.size(); }
	public TorrentFile get(int index){ return viewset.get(index);	}

	public void setView(String v){
		view = v;
		if(v.equalsIgnoreCase("main"))
			viewset = torrents;
		else
			viewset = new TorrentSet();
	}
	
	public long getRateDown() {
		return rateDown;
	}
	
	public long getRateUp() {
		return rateUp;
	}

	private String[] getHash(int[] i){
		int x = 0;
		String[] hashlist = new String[i.length];
		for(int index : i){
			hashlist[x++] = get(index).getHash();
		}
		return hashlist;
	}
	
	public void checkHash(int[] i){
		rpc.fileCommand(getHash(i),"d.check_hash");
	}
	public void close(int[] i){
		rpc.fileCommand(getHash(i), "d.close");
	}
	public void erase(int[] i){
		rpc.fileCommand(getHash(i), "d.erase");
	}
	public void open(int[] i){
		rpc.fileCommand(getHash(i), "d.open");
	}
	public void start(int[] i){
		rpc.fileCommand(getHash(i), "d.start");
	}
	public void stop(int[] i){
		rpc.fileCommand(getHash(i), "d.stop");
	}
	
	public void stopAll(){
		String[] s = new String[torrents.size()];
		torrents.getHashSet().toArray(s);
		rpc.fileCommand(s, "d.stop");
	}
	
	public void startAll(){
		String[] s = new String[torrents.size()];
		torrents.getHashSet().toArray(s);
		rpc.fileCommand(s, "d.start");
	}

	private void removeOutdated() {
		for(int x = 0; x < viewset.size(); x++){
			TorrentFile tf = viewset.get(x);
			if(tf.isOutOfDate()){
				viewset.remove(x);
				table.fireTableRowsDeleted(x, x);
			}
		}
	}

	@Override
	public void handleResult(XmlRpcRequest pRequest, Object pResult) {

		rateUp = rateDown = 0;
		Object[] obj = (Object[])pResult;
		int viewSize = viewset.size();
		boolean fullUpdate = true;
		if(pRequest.getParameterCount() == Rpc.variable.length)
			fullUpdate = false;
		
		/**@TODO not happy with this solution**/
		for(int x = 0; x < obj.length; x++){
			Object[] raw = (Object[])obj[x];
			TorrentFile tf = torrents.get((String)raw[0]);
			if(tf == null && fullUpdate){
				tf = new TorrentFile((String)raw[0]);
				tf.initialize(raw);
				torrents.add(tf);
				table.fireTableRowsInserted(x, x);
			}else if(tf == null && !fullUpdate){
				Controller.getMainContentThread().interrupt();
				break;
			}
	
			viewset.add(tf);
			tf.update(raw);
			
			rateUp += tf.getRateUp().getValue();
			rateDown += tf.getRateDown().getValue();
			
		}
		if(viewSize == 0)
			table.fireTableDataChanged();
		else
			table.fireTableRowsUpdated(0, obj.length);
		removeOutdated();
	}	
}