package com.sagarrathod.jokes;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sagar Rathod
 * @version 1.0
 *
 * Java Joke API to provide the random jokes.
 *
 */
public class Jokes {

    // list of jokes
    static private List<String> jokes = new ArrayList<String>();

    static private Random randomNumGenegrator = new Random();

    //Singleton instance
    private static Jokes jokesInstance = new Jokes();

    String firstJoke = "The Perfect Son. \n" +
            "A: I have the perfect son. \n" +
            "B: Does he smoke? \n" +
            "A: No, he doesn't. \n" +
            "B: Does he drink whiskey? \n" +
            "A: No, he doesn't. \n" +
            "B: Does he ever come home late? \n" +
            "A: No, he doesn't. \n" +
            "B: I guess you really do have the perfect son. How old is he? \n" +
            "A: He will be six months old next Wednesday.\n" +
            "Girl: You would be a good dancer except for two things. \n" +
            "Boy: What are the two things? \n" +
            "Girl: Your feet. \n" +
            "##Submitted by Bob Waldman";
    String secondJoke = "A man goes to the doctor and says, \"Doctor, wherever I touch, it hurts.\" \n" +
            "The doctor asks, \"What do you mean?\" \n" +
            "The man says, \"When I touch my shoulder, it really hurts. If I touch my knee - OUCH! When I touch my forehead, it really, really hurts.\" \n" +
            "The doctor says, \"I know what's wrong with you - you've broken your finger!\" \n" +
            "##Submitted by Sean McLoughlin";
    String thirdJoke = "Patient: Doctor, I have a pain in my eye whenever I drink tea. \n" +
            "Doctor: Take the spoon out of the mug before you drink. \n" +
            "##Submitted by: Irene Pellegrini";
    String fourthJoke = "A: Just look at that young person with the short hair and blue jeans. Is it a boy or a girl? \n" +
            "B: It's a girl. She's my daughter. \n" +
            "A: Oh, I'm sorry, sir. I didn't know that you were her father. \n" +
            "B: I'm not. I'm her mother.\n" +
            "Mother: \"Did you enjoy your first day at school?\" \n" +
            "Girl: \"First day? Do you mean I have to go back tomorrow? \n" +
            "##Submitted by Miguel de Paco Moltó";
    String fifthJoke = "Teacher: \"Nick, what is the past participle of the verb to ring?\" \n" +
            "Nick: \"What do you think it is, Sir?\" \n" +
            "Teacher: \"I don't think, I KNOW!\" \n" +
            "Nick: \"I don't think I know either, Sir!\" \n" +
            "##Submitted by Bernadette Kelly";
    String sixthJoke = "A: Hey, man! Please call me a taxi. \n" +
            "B: Yes, sir. You are a taxi. \n" +
            "##Submitted by Cláudia Almeida";
    String seventhJoke = "Two goldfish in a bowl talking: \n" +
            "Goldfish 1: Do you believe in God? \n" +
            "Goldfish 2: Of course, I do! Who do you think changes the water?\n" +
            "Son: Dad, what is an idiot? \n" +
            "Dad: An idiot is a person who tries to explain his ideas in such a strange and long way that another person who is listening to him can't understand him. Do you understand me? \n" +
            "Son: No.\n" +
            "Man: I could go to the end of the world for you. \n" +
            "Woman: Yes, but would you stay there?\n" +
            "Man: I offer you myself. \n" +
            "Woman: I am sorry I never accept cheap gifts.\n" +
            "\n" +
            "Man: I want to share everything with you. \n" +
            "Woman: Let's start from your bank account. \n" +
            "##Submitted by kara dolson";
    String eighthJoke = "Once there were three turtles. One day they decided to go on a picnic. When they got there, they realized they had forgotten the soda. The youngest turtle said he would go home and get it if they wouldn't eat the sandwiches until he got back. A week went by, then a month, finally a year, when the two turtles said,\"oh, come on, let's eat the sandwiches.\" Suddenly the little turtle popped up from behind a rock and said, \"If you do, I won't go!\" \n" +
            "##Submitted by Abu Abdulaziz (Kuwait)";
    String ninthJoke = "The teacher to a student: Conjugate the verb \"to walk\" in simple present. \n" +
            "The student: I walk. You walk .... \n" +
            "The teacher intruptes him: Quicker please. \n" +
            "The student: I run. You run ... \n" +
            "##Submitted by: Mouhssin\n";
    String tenthJoke = "Teacher: Did your father help your with your homework? \n" +
            "Student: No, he did it all by himself.\n" +
            "Teacher: What are some products of the West Indies? \n" +
            "Student: I don't know. \n" +
            "Teacher: Of course, you do. Where do you get sugar from? \n" +
            "Student: We borrow it from our neighbor.";

    /**
     * Creates the lhe list of predefined jokes.
     */
    private Jokes() {
        jokes.add(firstJoke);
        jokes.add(secondJoke);
        jokes.add(thirdJoke);
        jokes.add(fourthJoke);
        jokes.add(fifthJoke);
        jokes.add(sixthJoke);
        jokes.add(seventhJoke);
        jokes.add(eighthJoke);
        jokes.add(ninthJoke);
        jokes.add(tenthJoke);
    }

    /**
     * Returns the singleton instance.
     * @return
     */
    public static Jokes getInstance() {
        return jokesInstance;
    }

    /**
     * Returns the random joke from the list of predefined jokes.
     * @return
     */
    public String getRandomJoke() {
        int randomJoke = randomNumGenegrator.nextInt(jokes.size());
        return jokes.get(randomJoke).toString();
    }

}
