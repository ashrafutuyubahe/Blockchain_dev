public class MiningPoolTest {
    
    public static void main(String[] args) {
        
        // Create a new blockchain with a difficulty level of 4 (difficulty defines the number of leading zeros in the hash)
        Blockchain myBlockchain = new Blockchain(4);

        // Print out the genesis block
        System.out.println("Genesis Block: " + myBlockchain.getChain().get(0).getBlockHash());

        // Add a new block to the blockchain
        System.out.println("\nMining block 1...");
        Block block1 = new Block(1, "Transaction: Alice pays Bob 10 BTC", myBlockchain.getChain().get(0).getBlockHash());
        block1.mineBlock(myBlockchain.difficultLevel); // Mine the block with difficulty level
        myBlockchain.addNewBlock(block1);
        System.out.println("Block 1 mined with hash: " + block1.getBlockHash());

        // Add another block
        System.out.println("\nMining block 2...");
        Block block2 = new Block(2, "Transaction: Bob pays Charlie 5 BTC", block1.getBlockHash());
        block2.mineBlock(myBlockchain.difficultLevel); // Mine the block with difficulty level
        myBlockchain.addNewBlock(block2);
        System.out.println("Block 2 mined with hash: " + block2.getBlockHash());

        // Validate the blockchain
        System.out.println("\nIs blockchain valid? " + myBlockchain.isChainValid());

        // Print all blocks in the blockchain
        System.out.println("\nAll blocks in the blockchain:");
        for (Block block : myBlockchain.getChain()) {
            System.out.println("Block Index: " + block.getBlockIndex());
            System.out.println("Block Data: " + block.getData());
            System.out.println("Block Hash: " + block.getBlockHash());
            System.out.println("Previous Hash: " + block.getPrevHash());
            System.out.println("-----");
        }
    }
}
