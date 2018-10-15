public enum OperationType {

    DEPOSIT("deposit"),
    WITHDRAWAL("Withdrawal"),
    FULLWITHDRAWAL("Full withdrawal");

    private String name;

    OperationType(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
