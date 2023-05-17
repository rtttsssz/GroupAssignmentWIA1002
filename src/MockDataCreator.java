import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MockDataCreator {

    private static final List<String> NAMES = Arrays.asList(
            "John", "Emma", "Michael", "Olivia", "William", "Sophia", "James", "Ava", "Benjamin", "Isabella",
            "Daniel", "Mia", "Henry", "Charlotte", "Alexander", "Amelia", "David", "Harper", "Joseph", "Evelyn"
    );

    private static final List<String> LAST_NAMES = Arrays.asList(
            "Smith", "Johnson", "Brown", "Taylor", "Davis", "Miller", "Wilson", "Moore", "Clark", "Lewis")// Add more last names as needed
    ;
    private static final List<String> HOBBIES = Arrays.asList(
            "Reading", "Cooking", "Sports", "Painting", "Photography", "Gaming", "Traveling", "Music", "Dancing", "Eating"
    );

    private static final List<String> JOBS = Arrays.asList(
            "Engineer", "Teacher", "Doctor", "Artist", "Writer", "Chef", "Athlete", "Musician", "Designer","Student","FreeLancer","Umemployed"
    );

    private static final Random random = new Random();

    private static final String UPPER_CASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String PUNCTUATION_CHARS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String ALL_CHARS = UPPER_CASE_CHARS + LOWER_CASE_CHARS + PUNCTUATION_CHARS + NUMBERS;

    private static SecureRandom securerandom = new SecureRandom();

    public List<User> createNormalUsers(int numUsers) {
        List<User> normalUsers = new ArrayList<>();//declarded as type List<User>, but it refers to the instance of ArrayList
        for (int i = 0; i < numUsers; i++) {
            User user = new User();
            user.setName(generateRandomName());//name with space
            String name = Namewospace(user.getName()); // create variable store name without space for username & email
            user.setUsername(generateUsername(name));// set the username by using generateUsername method with the input name
            user.setEmailAddress(generateEmail(name));//  By using the name of the user, generate the email and then set the email address.
            user.setPassword(generateRandomPassword());// generate a random password for the user
            user.setContactNumber(generateRandomContactNumber());// Generate random contact number and then set it as the contact number of this user
            user.setBirthday(generateRandomBirthday()); //randomly generate birthday
            user.setAge(calculateAge(user.getBirthday())); // based on the birthday generated before, calculate the age of the user
            user.setAddress(generateRandomAddress());// randomly assign the address based on the list
            user.setGender(generateGender(user.getName()));//based on the name, assign the gender to them.
            user.setNumFriends(0); // at the beginning, there is no friend for everyone, sad.
            user.setHobbies(generateRandomHobbies()); // random hobby/ies is/are assigned to the users and set it/them as the hobby/hobbies of this user.
            user.setJob(generateRandomJob());//randomly assign one job for this user.
            user.setRole("User"); // Set the role as "user" for users
            normalUsers.add(user);//add this user to the normalUsers list
        }
        return normalUsers;
    }
    public List<User> createAdminUsers(int numUsers) {
        List<User> adminUsers = new ArrayList<>();//declarded as type List<User>, but it refers to the instance of ArrayList
        for (int i = 0; i < numUsers; i++) {
            User adminuser = new User();
            adminuser.setName(generateRandomName());//name with space
            String name = Namewospace(adminuser.getName()); // create variable store name without space for username & email
            adminuser.setUsername(generateUsername(name));// set the username by using generateUsername method with the input name
            adminuser.setEmailAddress(generateEmail(name));//  By using the name of the admin, generate the email and then set the email address.
            adminuser.setPassword(generateRandomPassword());// generate a random password for the admin
            adminuser.setContactNumber(generateRandomContactNumber());// Generate random contact number and then set it as the contact number of this admin
            adminuser.setBirthday(generateRandomBirthday()); //randomly generate birth day
            adminuser.setAge(calculateAge(adminuser.getBirthday())); // based on the birthday generated before, calculate the age of the admin
            adminuser.setAddress(generateRandomAddress());// randomly assign the address based on the list
            adminuser.setGender(generateGender(adminuser.getName()));//based on the name, assign the gender to them.
            adminuser.setNumFriends(0); // at the beginning, there is no friend for everyone, sad.
            adminuser.setHobbies(generateRandomHobbies()); // random hobby/ies is/are assigned to the admin and set it/them as the hobby/hobbies of this admin.
            adminuser.setJob(generateRandomJob());//randomly assign one job for this admin.
            adminuser.setRole("Admin"); // Set the role as "admin" for admin
            adminUsers.add(adminuser);//add this Admin to the AdminUsers list
        }

        return adminUsers;
    }

    private String generateRandomName() {
        ArrayList <String> name = new ArrayList<>();
        String RandomName = NAMES.get(random.nextInt(NAMES.size()))+" " + LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
        while(name.contains(RandomName)){
            RandomName = NAMES.get(random.nextInt(NAMES.size()))+" " + LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
        }
        name.add(RandomName);
        return RandomName;
    }

    private String Namewospace(String name) {
        String [] namelist = name.split(" ");
        return namelist[0]+namelist[1];
    }

    private String generateUsername(String Sname) {
        String name = Sname;
        int number = random.nextInt(10000);
        return name.toLowerCase() + number;
    }

    private String generateEmail(String name) { //need a list or array to store the email and when register or generate, will not duplicate.
        String username = name;
        String domain = "@thefacebook.com";
        return username + domain;
    }

    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(ALL_CHARS.length());
            password.append(ALL_CHARS.charAt(randomIndex));
        }

        return password.toString();
    }


    private String generateRandomContactNumber() { //same as email, no duplicate
        ArrayList <String> noRepeatNum = new ArrayList<>();
        StringBuilder contactNumber = new StringBuilder();
        contactNumber.append("01");
        contactNumber.append(random.nextInt(10));
        contactNumber.append('-');
        if(contactNumber.toString().equals("011-")){
            for(int i = 0; i < 8;i++){
                contactNumber.append(random.nextInt(10));
            }
        }
        else
            for(int i = 0; i < 7;i++){
                contactNumber.append(random.nextInt(10));
            }

        return contactNumber.toString();
    }

    private LocalDate generateRandomBirthday() {
        int year = random.nextInt(71) +1950; // Random year between 1950 and 2020
        int month = random.nextInt(12) + 1; // Random month between 1 and 12
        int day = 0;
        if(month == 2){
             day = random.nextInt(28) + 1;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
             day = random.nextInt(30) + 1;
        }else {
             day = random.nextInt(31) + 1;
        }

        return LocalDate.of(year, month, day);
    }

    private int calculateAge(LocalDate birthday) {
        LocalDate now = LocalDate.now();
        return now.getYear() - birthday.getYear();
    }

    private String generateRandomAddress() {
        String[] streets = {"Main St", "First Ave", "Maple Rd", "Elm St", "Oak Ave"};
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
        String[] states = {"NY", "CA", "IL", "TX", "AZ"};
        int streetIndex = random.nextInt(streets.length);
        int cityIndex = random.nextInt(cities.length);
        int stateIndex = random.nextInt(states.length);
        return streets[streetIndex] + ", " + cities[cityIndex] + ", " + states[stateIndex]; //randomly give the address with randomly index.
    }

    //need some changes
    private String generateGender(String name) {
        List<String> MaleName = Arrays.asList("John", "Michael", "William", "James", "Benjamin", "Daniel","Henry","Alexander","David", "Harper", "Joseph");
        //String[] genders = {"Male", "Female"};
        //return genders[random.nextInt(genders.length)];
        String [] namelist = name.split(" ");
        if(MaleName.contains(namelist[0])){
            return "Male";
        }
        else
            return "Female";
    }

    private List<String> generateRandomHobbies() {
        int numHobbies = random.nextInt(3) + 1; // Randomly generate 1-3 hobbies
        List<String> randomHobbies = new ArrayList<>();
        for (int i = 0; i < numHobbies; i++) {
            int index = random.nextInt(HOBBIES.size());
            randomHobbies.add(HOBBIES.get(index));
        }
        return randomHobbies;
    }

    private String generateRandomJob() {
        int index = random.nextInt(JOBS.size());
        return JOBS.get(index);
    }

    public static void main(String[] args) {
            MockDataCreator dataCreator = new MockDataCreator();
            List<User> normalUsers = dataCreator.createNormalUsers(30);
            List<User> adminUsers = dataCreator.createAdminUsers(2);
        /*
         create an object named dataCreator by having the reference at the MockDataCreator class, then initialise a
         */

        // Save the generated users to a text file
            String fileName = "users.txt";
            saveUsersToFile(normalUsers, fileName);
            saveUsersToFile(adminUsers,fileName);
    }

    private static void saveUsersToFile(List<User> users, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            int i = 1;
            for (User user : users) {
                writer.write(user.getRole()+": " + i);
                writer.newLine();
                writer.write("Name: " + user.getName());
                writer.newLine();
                writer.write("Username: " + user.getUsername());
                writer.newLine();
                writer.write("Email Address: " + user.getEmailAddress());
                writer.newLine();
                writer.write("Password: "+ user.getPassword());
                writer.newLine();
                writer.write("Contact Number: " + user.getContactNumber());
                writer.newLine();
                writer.write("Birthday: " + user.getBirthday());
                writer.newLine();
                writer.write("Age: " + user.getAge());
                writer.newLine();
                writer.write("Address: " + user.getAddress());
                writer.newLine();
                writer.write("Gender: " + user.getGender());
                writer.newLine();
                writer.write("Number of Friends: " + user.getNumFriends());
                writer.newLine();
                writer.write("Hobbies: " + user.getHobbies());
                writer.newLine();
                writer.write("Job: " + user.getJob());
                writer.newLine();
                writer.write("Relationship Status: " + user.getRelationshipStatus());
                writer.newLine();
                writer.write("Role: "+ user.getRole());
                writer.newLine();
                writer.write("------------------------");
                writer.newLine();
                writer.newLine();
                i++;
            }

            System.out.println("Users saved to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save users to the file: " + fileName);
            e.printStackTrace();
        }
    }
}




