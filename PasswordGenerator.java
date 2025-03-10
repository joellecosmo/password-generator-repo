import java.util.Random;
public class PasswordGenerator {
    public static final String LOWERCASE_CHARACTERS="abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    private final Random random;
    public PasswordGenerator(){
        random =new Random();
    }
    private String createCharacterPool(boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSymbols){
        StringBuilder pool = new StringBuilder();
        if(includeUppercase) pool.append(UPPERCASE_CHARACTERS);
        if(includeLowercase)pool.append(LOWERCASE_CHARACTERS);
        if(includeNumbers) pool.append(NUMBERS);
        if (includeSymbols) pool.append(SPECIAL_SYMBOLS);

        return pool.toString();
         }

        public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSymbols){
        String characterPool = createCharacterPool(includeUppercase,includeLowercase,includeNumbers,includeSymbols);
        if(characterPool.isEmpty()) throw new IllegalArgumentException("Select at least one character type");
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        random.ints(length, 0, characterPool.length())
                    .forEach(i -> password.append(characterPool.charAt(i)));

            return password.toString();

        }
    }

