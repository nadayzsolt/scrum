# Scrumpoker checklist

## Structure:

Entities: User, Sprint, Task, Estimation // created

Repos: -||- // created

DB-structure // created

Controller // created

Service // created

Unit- Integration-tests // -

Results (GameAvg, -list) shown // -

Spring Mobile // somehow "deprecated" & not supported by Gradle 7... therefore probably avoided

Docker // - 

## Endpoints:

### Admin(-istrator // not real admin, no admin authentication needed)
1. Post Event (launching estimating round of the first task)
2. Get Results of actual task (~ refresh)
3. Post reset (new task within the same sprint/
   confirming results of previous task bidding/ 
   creating task object)

### Plain User (Player authenticated by the knowledge randomly generated event nr.)
4. Post name (for him-/herself if not existing name, can confirm the registration of new name)
5. Post estimation upon actual task
6. Get redirected to Post points page (if Admin made reset already)

### Everyone (preferably after planning poker took place)
7. Get resultList by sprintCode
8. Get avg by taskCode
