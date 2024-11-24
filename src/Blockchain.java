import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain;
    private int difficultLevel;

    public Blockchain(int difficuly) {

        chain = new ArrayList<>();
        Block GenesisBLock = new Block(0, "Genesis block", "0");
        chain.add(GenesisBLock);
        this.difficultLevel=difficuly;
    }


    public boolean isChainValid() {
        // Iterate over the chain starting from the second block (index 1)
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i); // Get the current block
            Block previousBlock = chain.get(i - 1);  // Get the previous block
    
            // Validate the current block's hash by recalculating it
            if (!currentBlock.getBlockHash().equals(currentBlock.calculateBlockHash())) {
                return false; // If the hashes don't match, the block is invalid
            }
    
            // Validate the previous block's hash by comparing it with the current block's prevHash
            if (!currentBlock.getPrevHash().equals(previousBlock.getBlockHash())) {
                return false; // If the previous hashes don't match, the chain is invalid
            }
        }
        return true; // If all blocks are valid, return true
    }
    


    public List<Block> getChain() {
        return chain;
    }

    public void addNewBlock(Block newBlock) {
        newBlock.setPrevHash(chain.get(chain.size() - 1).getBlockHash());
        newBlock.setBLockHash(newBlock.calculateBlockHash());

    }

}
