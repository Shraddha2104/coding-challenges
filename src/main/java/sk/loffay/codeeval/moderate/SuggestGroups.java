package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 49.122
 * mem: 9654272
 */
public class SuggestGroups {

    private final Map<String, Person> people;

    public SuggestGroups(String fileName) throws IOException {
        people = parseFile(fileName);
    }

    public static void main (String[] args) throws IOException {
        SuggestGroups groupSuggester = new SuggestGroups(args[0]);
        groupSuggester.printGroupRecommendations();
    }

    public void printGroupRecommendations() {

        for (Map.Entry<String, Person> personEntry: people.entrySet()) {
            Person person = personEntry.getValue();

            int numberOfFriends = person.friends.size();
            Map<String, Integer> friendsGroups = new TreeMap<>();

            for (Person friend: person.friends) {
                for(String group: friend.groups) {

                    Integer numberOfOccurences = friendsGroups.get(group);
                    if (numberOfOccurences == null) {
                        numberOfOccurences = 0;
                    }

                    friendsGroups.put(group, ++numberOfOccurences);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> groupCount: friendsGroups.entrySet()) {
                Integer count = groupCount.getValue();
                if (count/(double)numberOfFriends >= 0.5 &&
                        !personEntry.getValue().groups.contains(groupCount.getKey())) {
                    stringBuilder.append(groupCount.getKey()).append(",");
                }
            }

            if (stringBuilder.length() > 0) {
                System.out.println(personEntry.getKey() + ":" +
                        stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
            }
        }
    }

    private Map<String, Person> parseFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        Map<String, Person> personMap = new TreeMap<>();

        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(":");

            String userName = split[0].trim();

            Person person = personMap.get(userName);
            if (person == null) {
                person = new Person(userName);
                personMap.put(userName, person);
            }

            if (split.length > 1) {
                addFiends(person, split[1].split(","), personMap);
            }

            if (split.length > 2) {
                addGroups(person, split[2].split(","));
            }
        }

        return personMap;
    }

    private void addGroups(Person person, String[] hobbies) {

        for (String hobby: hobbies) {
            person.groups.add(hobby);
        }
    }

    private void addFiends(Person person, String[] friends, Map<String, Person> people) {

        for (String friendName: friends) {

            Person friend = people.get(friendName);
            if (friend == null) {
                friend = new Person(friendName);
                people.put(friendName, friend);
            }

            person.friends.add(friend);
        }
    }

    private static class Person {
        private String name;
        private Set<Person> friends;
        private Set<String> groups;

        public Person(String name) {
            this.name = name;
            this.groups = new HashSet<>();
            this.friends = new HashSet<>();
        }
    }
}
