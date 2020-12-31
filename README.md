# Scrumpoker checklist

Project planned to have the following endpoints:

~ Admin(-istrator)
1. Post Party (first game within the ~session) 
2. Get Results of actual task (~ refresh)
3. Post reset (new game within the same party/
   confirming results of previous game)

~ Plain User (Player)
4. Post name (for him-/herself)
5. Post points for actual task
6. Get redirected to Post points page (if Admin made reset already)

Everyone (preferably between two parties)
7. Get resultList by partyId
8. Get avg by taskNumber

Other tasks:
Entities: User, Task, Game
EntityRepos: -||-
Results (GameAvg, -list) shown
DB
Controller
Service
Unit- Integration-tests
Docker