package com.martin.tree;

public class VerifyPreOrderSerial {
	public static boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length() == 0) return false;
        String[] data = preorder.split(",");
 		return checkIfPre(data,0,data.length-1);
    }
	
	public static boolean checkIfPre(String[] data, int start, int end) {
		if(start > end ) return false;
		if(data[start].equals("#")){
			if(end - start == 0) return true;
			else return false;
		}else{
			//in here we have real nodes
			if(end - start < 2) return false;
			for(int i=start+1;i<end;i++) {
				if(data[i].equals("#")) {
					if(checkIfPre(data,start+1,i) && checkIfPre(data,i+1,end))
						return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String waha = "9,9,9,9,9,9,9,9,#,9,#,#,9,#,9,#,#,#,9,9,#,9,#,#,9,#,9,#,#,9,9,9,#,9,#,#,9,#,#,9,#,#,9,9,9,9,9,#,#,#,9,9,#,9,9,9,9,#,#,#,#,9,#,9,9,#,#,#,9,#,#,9,9,9,#,#,9,9,#,#,9,9,#,#,#,9,#,9,9,9,9,#,#,#,#,9,#,#,9,9,9,#,9,#,#,9,9,9,#,#,9,#,#,9,9,#,9,#,9,9,#,#,#,9,#,#,9,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,9,9,9,#,9,#,#,9,#,#,9,9,#,9,#,#,9,9,#,#,9,#,#,#,9,9,9,#,#,9,#,#,9,9,9,#,#,9,9,#,#,#,9,#,9,#,9,#,#";
		boolean res = isValidSerialization(waha);
		System.out.println();
	}

}
