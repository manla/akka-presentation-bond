akka-presentation-bond holds the files used for a small introduction into akka 
given the 1st of March 2016 at the Rhein-Main Scala Enthusiasts meeting in Darmstadt
(http://www.meetup.com/de-DE/Rhein-Main-Scala-Enthusiasts/).
Thanks to the organizers and the community there.

Directory presentation holds the slides in keynote format and in pdf.
Directory bond-actor is a small akka projects. It was created with
'acticator new', using template 'minimal-akka-scala-seed'.
It illustrates the most basic features of akka implementing
a little James Bond scenario sketched in the presentation.
Of course, in the end Bond will kill the villains :-)

Provided that sbt is installed, the scenario can be run by 
going into directory 'bond-actor' and typing 'sbt run'.

Classes:
- Scenario shows the creation of actors
- Villain shows a basic actor
- SpecialAgent introduces changing behavior with 'become'
- Regisseur is only used to trigger behavior change

The principle of a movie script could be enhanced further to present more advanced features. 
For example, an idea to illustrate supervision would be to introduce a SuperVillain,
who watches his handymen and restarts them, when they got shot.

Have fun!

Martin Anlauf 
