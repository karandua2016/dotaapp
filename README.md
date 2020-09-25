## DOTA Player/Hero Details Fetcher
This app fetches the details of the Heros used by a player in Dota. It calls the publicly hosted DOTA Open API to fetch this information.

### What is fetched?
Details of the top three heros (most played with) is fetched.

### Prerequisites
Java 1.8+

### How to run?
Download/copy the jar file - dotaapp.jar from the target directory to your machine and run the following command

```java -jar dotaapp.jar <account_id>```

### Sample run command

```java -jar target/dotaapp.jar 376825272```

### Sample output

```
[ {
  "hero_id" : 14,
  "name" : "npc_dota_hero_pudge",
  "localized_name" : "Pudge"
}, {
  "hero_id" : 8,
  "name" : "npc_dota_hero_juggernaut",
  "localized_name" : "Juggernaut"
}, {
  "hero_id" : 44,
  "name" : "npc_dota_hero_phantom_assassin",
  "localized_name" : "Phantom Assassin"
} ]

```

### Assumption
The OpenDOTA API for pulling the most played with Heros, returns results even if a random account id is entered (integer, ofcourse). If the id is not found, it returns a list of all the heros with games played = 0. So, the app assumes that the account id searched exists. 
