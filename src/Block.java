import java.util.Date;

public class Block{

private int blockIndex;
private String  data;
private String prevHash;
private String  blockHash;
private Long timeStamps= new Date().getTime();
private int nonce;

public Block(int index,String data, String hash,String prevHash){
    this.blockIndex= index;
    this.data= data;
    this.nonce=0;
    this.blockHash= calculateBlockHash();
    
    }
    
    private String calculateBlockHash() {
        String input= blockIndex  + prevHash + nonce + data + timeStamps;

        return input;
    }

}