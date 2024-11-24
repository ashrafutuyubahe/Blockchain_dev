import java.util.Date;

public class Block{

private int blockIndex;
private String  data;
private String prevHash;
private String  blockHash;
private Long timeStamps= new Date().getTime();
private int nonce;

public Block(int index,String data,String prevHash){
    this.blockIndex= index;
    this.data= data;
    this.nonce=0;
    this.prevHash= prevHash;
    this.blockHash= calculateBlockHash();
    
    }
    
    public String calculateBlockHash() {
        String input= blockIndex  + prevHash + nonce + data + timeStamps;

        return input;
    }



    //getters & setter

    public String getPrevHash(){
        return prevHash;
    }

    public String getBlockHash(){
        return prevHash;
    }

   


    public void setPrevHash(String newPrevHash){
        this.prevHash=newPrevHash;
    }

    public void setBLockHash(String newBlockHash){
      this.blockHash= newBlockHash;
    }


    



}