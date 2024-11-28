import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain;
    int difficultLevel;

    public Blockchain(int difficuly) {

        chain = new ArrayList<>();
        Block GenesisBLock = new Block(0, "Genesis block", "0");
        chain.add(GenesisBLock);
        this.difficultLevel=difficuly;
    }


    public boolean isChainValid() {
       
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i); 
            Block previousBlock = chain.get(i - 1); 
    
          
            if (!currentBlock.getBlockHash().equals(currentBlock.calculateBlockHash())) {
                return false;
            }
    
         
            if (!currentBlock.getPrevHash().equals(previousBlock.getBlockHash())) {
                return false;
            }
        }
        return true; 
    }
    


    public List<Block> getChain() {
        return chain;
    }

    public void addNewBlock(Block newBlock) {
        newBlock.setPrevHash(chain.get(chain.size() - 1).getBlockHash());
        newBlock.setBLockHash(newBlock.calculateBlockHash());

    }

}
