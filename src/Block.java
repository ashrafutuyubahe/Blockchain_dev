import java.security.MessageDigest;
import java.util.Date;

public class Block {

    private int blockIndex;
    private String data;
    private String prevHash;
    private String blockHash;
    private Long timeStamps = new Date().getTime();
    private int nonce;

    public Block(int index, String data, String prevHash) {
        this.blockIndex = index;
        this.data = data;
        this.nonce = 0;     
        this.prevHash = prevHash;  
        this.blockHash = calculateBlockHash();

    }

    public String calculateBlockHash() {
        String input = blockIndex + prevHash + nonce + data + timeStamps;

        return applySHA256(input);
    }

    private String applySHA256(String input) {
        try {
            MessageDigest sha = MessageDigest
                    .getInstance(
                            "SHA-256");
            int i = 0;

            byte[] hash = sha.digest(
                    input.getBytes("UTF-8"));

            StringBuffer hexHash = new StringBuffer();

            while (i < hash.length) {
                String hex = Integer.toHexString(
                        0xff & hash[i]);
                if (hex.length() == 1)
                    hexHash.append('0');
                hexHash.append(hex);
                i++;
            }

            return hexHash.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); 
        while (!blockHash.substring(0, difficulty).equals(target)) {
            nonce++;  
            blockHash = calculateBlockHash(); 
        }
    }
    



    

 


    public String getPrevHash() {
        return prevHash;
    }

    public String getBlockHash() {
        return prevHash;
    }


    public int  getBlockIndex() {
        return blockIndex;
    }


    public void setPrevHash(String newPrevHash) {
        this.prevHash = newPrevHash;
    }

    public void setBLockHash(String newBlockHash) {
        this.blockHash = newBlockHash;
    }

    public String getData() {
        return  data;
    }



}