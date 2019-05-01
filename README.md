# SciFi UI Project

Name: Meenal Mujahed

Student Number: C17427304

Fork this repository and use it a starter project for your assignment

# Description of the assignment
I created a Sci-Fi User Interface which is based on the idea of Humans living in space for about a hundred years who have no Planet(Earth) to go back to. For generations they have living on a space ship. They are searching for an Earthlike planet in another galaxy and start a new life there. The UI enables the user to know some information about the planets and the species that run the planet.

# Instructions
When the program runs a loading screen with bright circles appears. The User will then need to press 'Enter' which will take them into the main part of Interface. Here there some options for User interaction. If the User hovers over the colorful red bars beside the planet description button then where ever the positions of mouseX and mouseY are the colour will change from red to a dark blue. This only occurs if mouseX and mouseY are on the bars.

Once the User is done with that. They can click the names of the five different planets. This will bring the user to the description of the planet. There is an image with text specifying the planet "Name", "About" and "Species". To go back to the main part the 'Back Space' is required to be pressed. The user can do the same with all the planet buttons.   

The user can then hover over the Sine Wave labelled "Radio Wave". This will alter and increase the frequency of the wave and will also play some static noise while the user still hovers over the wave. When the user is not hovering over the Sine Wave the static sound effects will not play.
# How it works

## UI Class
The UI class is where everything is rendered and called. This is where I implemented code for the Globe, the Sine Wave and the loading screen. Here, the Array lists and their declarations are stored with other methods like mousePressed and keyPressed. To make the 3D globe translate(x,y,z) was also used. I used a lot of If/Else statments, especially to make sure I was going to different planets if I clicked between certain x,y values. I also used polymorphism in this class.

## UIElement Class
The UIElement class is the super class where all the other classes need to inherit from.

## Circle Class
This was used to draw the circle at the top and the right side of the screen. They are circles with rotating arcs which have random percentages inside it. The pushMatrix(), popMatrix(), translate(), rotate() were used. I used sin,cos, 
tan here aswell.

## Boxcolor Class
This class was used to make the red bars which change color where the mouse is just ahead of them. mouseX and mouseY is the position where the color blue where the surrounding will remain red.

## Fan Class
This class uses multiple ellipse() within a for loop. Which makes a perpeler like shape. The circles with in the outline rotate using pushMatrix(), popMatrix(), translate and rotation.

## Minimap Class
Used to draw the mini map of the galaxy in the top right corner.

## Planets Class
This class was used to make the rectangle shapes where the planet button is stored. The shape of the button was also make using this class.

## Box Class
Used to give structure to the main part. The Minimap is drawn within this and
so is the sign wave and the informaition text in the right bottom corner.

## Globle Class
The class is used to make the rotating arcs around the globle in the main page. With arc() being used mutiple times and with different float values. Each arc has a different color.  

## Background Class
This class was made for the purpose of having a grid pattern background to the assignment. However, with the success of the 3D features the background twisted with the center of the shpere being x and y.

## Button Class
This create the skeleton of the loading page. It is used to draw the circles. 

## Radar Class
This class uses PVector. It is for the radar. 

## Planetdata Class and Text Class
Thses classes are used to store the data that I wanted displayed. Using a constructor the data in the csv files will display on the main page and on the pages for each planet.


# What I am most proud of in the assignment

What I am most proud of is that I implemented most ideas thats I planned for this assignment. Getting started was the difficult part for me but with some research and coming up with different ideas, I finally decided on what I wanted to make.

I am really proud that I actually got the 3D shere to rotate even though I considered it a huge challenge for this assignment. I am proud that even when this assignment seemed difficult I kept going and in most cases reached the results I aimed hard for.

I am also very proud with my Sine Wave. Quiet a lot of thinking went into figuring out how to implement the if/else statment within the code for the actual Sine Wave, but I figured it out. Having the static sound there too also makes me proud.

Everyday after spending continuous hours on trying to figure out how to make each of my desired shapes I would create a new plan for the next day, this meant I numbered the different parts of the assignment I needed to finish the following day. If I thought of another way to make a certain shape it was included in my plan. This allowed me to keep track of what I needed to do.



# YouTube
This is a youtube video:

[![YouTube](http://img.https://youtu.be/POyih3poA_k.jpg)](https://www.youtube.com/watch?v=POyih3poA_k)


