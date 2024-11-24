import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    
    private List<Block> chain;
    
    public Blockchain(){

      chain= new ArrayList<>();

      Block GenesisBLock= new Block(0,"Genesis block","0");
      chain.add(GenesisBLock);
    }

    public List<Block> getChain(){
        return chain;
    } 

    public void addNewBlock(Block newBlock){
       newBlock.setPrevHash(chain.get(chain.size()-1).getBlockHash());
       newBlock.setBLockHash(newBlock.calculateBlockHash());
        
    }
}
