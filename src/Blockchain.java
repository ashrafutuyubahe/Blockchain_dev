import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain;
    int difficultLevel;

    public Blockchain(int difficulty) {
        chain = new ArrayList<>();
        Block genesisBlock = new Block(0, "Genesis block", "ef7797e13d3a75526946a3bcf00daec9fc9c9c4d51ddc7cc5df888f74dd434d1"); 
        chain.add(genesisBlock);
        this.difficultLevel = difficulty; 
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
        chain.add(newBlock);
    }
}
