import sqlite3
from telnetlib import Telnet
import tkinter.commondialog
import tkinter.filedialog
import tkinter.font
import tkinter.messagebox
from tkinter import *
import pyrebase
from tkinter import ttk
# import the necessary packages
from imutils import paths
import face_recognition
#import argparse
import pickle
import cv2
import os

from imutils.video import VideoStream
from imutils.video import FPS
import face_recognition
import imutils
import time
import smtplib, ssl
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

from datetime import datetime
import random
import string

import shutil



#--------------------------------------------------
# import RPi.GPIO as GPIO
# GPIO.setmode(GPIO.BCM)
# GPIO.setwarnings(False)
# GPIO.setup(17,GPIO.OUT)
# print("LED on")
# GPIO.setup(17,GPIO.HIGH)
# time.sleep(4)
# print("LED OFF")
# GPIO.setup(18,GPIO.LOW)

#--------------------------------------------------





#Initialize Firebase
firebaseConfig={
  "apiKey": "AIzaSyCk1uVx95D1LqkLuhk17DLMTvHP9nom1m8",
  "authDomain": "raspberypi-facereco.firebaseapp.com",
  "databaseURL":"https://raspberypi-facereco-default-rtdb.firebaseio.com",
  "projectId": "raspberypi-facereco",
  "storageBucket": "raspberypi-facereco.appspot.com",
  "messagingSenderId": "703934457168",
  "appId": "1:703934457168:web:89fbc1fbe428a643963855",
  "measurementId": "G-0XSV5P29Q8"
  }

firebase=pyrebase.initialize_app(firebaseConfig)

db=firebase.database()

# ** making new window ***
root = Tk()
root.title("Face Recognition System")
root.geometry("1720x720")
my_tree = ttk.Treeview(root)
storeName = "Face Recognition System"

#my functions 

def randomId():
    random1 =''.join([random.choice(string.ascii_letters+string.digits)for n in range(8)])
    return random1
    
def trainning():
        # our images are located in the dataset folder
    print("[INFO] start processing faces...")
    imagePaths = list(paths.list_images("dataset"))

    # initialize the list of known encodings and known names
    knownEncodings = []
    knownNames = []

    # loop over the image paths
    for (i, imagePath) in enumerate(imagePaths):
        # extract the person name from the image path
        print("[INFO] processing image {}/{}".format(i + 1,
            len(imagePaths)))
        name = imagePath.split(os.path.sep)[-2]

        # load the input image and convert it from RGB (OpenCV ordering)
        # to dlib ordering (RGB)
        image = cv2.imread(imagePath)
        rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

        # detect the (x, y)-coordinates of the bounding boxes
        # corresponding to each face in the input image
        boxes = face_recognition.face_locations(rgb,
            model="hog")

        # compute the facial embedding for the face
        encodings = face_recognition.face_encodings(rgb, boxes)

        # loop over the encodings
        for encoding in encodings:
            # add each encoding + name to our set of known names and
            # encodings
            knownEncodings.append(encoding)
            knownNames.append(name)

    # dump the facial encodings + names to disk
    print("[INFO] serializing encodings...")
    data = {"encodings": knownEncodings, "names": knownNames}
    f = open("encodings.pickle", "wb")
    f.write(pickle.dumps(data))
    f.close()
    tkinter.messagebox.showinfo(title="", message="traitement terminer :)")
    print("end encodding")

def fonctionCam(foldername):
    name = foldername #replace with your name

    cam = cv2.VideoCapture(0)

    cv2.namedWindow("press space to take a photo", cv2.WINDOW_NORMAL)
    cv2.resizeWindow("press space to take a photo", 900, 700)

    img_counter = 0
    #creating the images folder of the new personne
    path="dataset/"+foldername
    try:
        os.mkdir(path)
    except OSError as error:
        print("existe deja ")
        return
    
    
    while img_counter<=10:
        ret, frame = cam.read()
        if not ret:
            print("failed to grab frame")
            break
        cv2.imshow("press space to take a photo", frame)

        k = cv2.waitKey(1)
    
        if k%256 == 32:
            # SPACE pressed
            img_name = "dataset/"+ name +"/image_{}.jpg".format(img_counter)
            cv2.imwrite(img_name, frame)
            print("{} written!".format(img_name))
            img_counter += 1

    cam.release()
    cv2.destroyAllWindows()
    
def insert_user():
  
    itemName = str(entryName.get())
    itemLastName= str(entryLastName.get())
    itemBirthdate= str(entryBirthdate.get())
    itemAdresse= str(entryAdresse.get())
    itemTel= str(entryTel.get())
    itemMail= str(entryMail.get())

    if itemName == "" or itemName == " ":
        print("Error Inserting Name")
    if itemLastName == "" or itemLastName == " ":
        print("Error Inserting Lastname")    
    if  itemBirthdate == "" or  itemBirthdate == " ":
        print("Error Inserting Birthdate")
    if itemAdresse == "" or itemAdresse== " ":
        print("Error Inserting Adresse")
    if  itemTel == "" or  itemTel == " ":
        print("Error Inserting Tel")
    if itemMail == "" or itemMail== " ":
        print("Error Inserting Mail")     
    else:

        fonctionCam(itemName+" "+itemLastName)       
        tempId=randomId()
        db.child("user").push({"Id":tempId,"Name":itemName,"LastName":itemLastName,"Birthdate":itemBirthdate,"Adresse":itemAdresse,"Tel":itemTel,"Mail":itemMail})
        # asking for trainnig or can be done later 
        rep=tkinter.messagebox.askyesno(title="analyser les images ?", message="Analyser les image du "+itemName+" "+itemLastName+"?")
        if rep==True:
            tkinter.messagebox.showinfo(title="traitement", message="traitement des images en cours.....")
            trainning()
            tkinter.messagebox.showinfo(title="registration info", message=""+itemName+" "+itemLastName+"est enregistrer dans la base.")
        #else
        tkinter.messagebox.showinfo(title="registration info", message=""+itemName+" "+itemLastName+"est enregistrer dans la base.")    
        #clearing the feilds
        entryName.delete(0,END) 
        entryLastName.delete(0,END) 
        entryAdresse.delete(0,END) 
        entryBirthdate.delete(0,END) 
        entryMail.delete(0,END) 
        entryTel.delete(0,END)
        
        for data in my_tree.get_children():
            my_tree.delete(data)

        for result in read():
            my_tree.insert(parent='', index='end',  values=(result["Id"],result["Name"],result["LastName"],result["Birthdate"],result["Adresse"],result["Tel"],), tag="orow")

def pointPerson(nameOfpersone):
    timeNow=datetime.now().strftime("%d-%m-%Y %H:%M:%S")
    db.child("History").push({"Name":nameOfpersone,"Last_Time_seen":timeNow})
     
def scanPerson():
    import math
    #Initialize 'currentname' to trigger only when a new person is identified.
    currentname = "unknown"
    #Determine faces from encodings.pickle file model created from train_model.py
    encodingsP = "encodings.pickle"

    # load the known faces and embeddings along with OpenCV's Haar
    # cascade for face detection
    print("[INFO] loading encodings + face detector...")
    data = pickle.loads(open(encodingsP, "rb").read())

    # initialize the video stream and allow the camera sensor to warm up
    # Set the ser to the followng
    # src = 0 : for the build in single web cam, could be your laptop webcam
    # src = 2 : I had to set it to 2 inorder to use the USB webcam attached to my laptop
 
    #vs = VideoStream(src=2,framerate=10).start()
    #vs = VideoStream(usePiCamera=True,resolution=(int(math.floor(480)),int(math.floor(640)))).start()
    vs = VideoStream(usePiCamera=True).start()
    time.sleep(2.0)
    

    # start the FPS counter
    fps = FPS().start()

    # loop over frames from the video file stream
    while True:
        # grab the frame from the threaded video stream and resize it
        # to 500px (to speedup processing)
        frame = vs.read()
        frame = imutils.resize(frame, width=500)
        # Detect the face boxes
        boxes = face_recognition.face_locations(frame)
        # compute the facial embeddings for each face bounding box
        encodings = face_recognition.face_encodings(frame, boxes)
        names = []

        # loop over the facial embeddings
        for encoding in encodings:
            # attempt to match each face in the input image to our known
            # encodings
            matches = face_recognition.compare_faces(data["encodings"],
                encoding)
                
            name = "Unknown" #if face is not recognized, then print Unknown
            

            # check to see if we have found a match
            if True in matches:
                # find the indexes of all matched faces then initialize a
                # dictionary to count the total number of times each face
                # was matched
                matchedIdxs = [i for (i, b) in enumerate(matches) if b]
                counts = {}

                # loop over the matched indexes and maintain a count for
                # each recognized face face
                for i in matchedIdxs:
                    name = data["names"][i]
                    counts[name] = counts.get(name, 0) + 1

                # determine the recognized face with the largest number
                # of votes (note: in the event of an unlikely tie Python
                # will select first entry in the dictionary)
                name = max(counts, key=counts.get)
                
                    

                #If someone in your dataset is identified, print their name on the screen
                if currentname != name:
                    currentname = name
                    pointPerson(currentname)
                    print(currentname)
                
            # update the list of names
            names.append(name)
            if name.lower()=="unknown" and currentname!=name:
                currentname=name
                print("Unknown person is detected send notification and save data now ")
                #Notification 
                timeNow=datetime.now().strftime("%d-%m-%Y %H:%M:%S")
                sendMail(timeNow)
                
                #get Capture and save it 
                currentTime=datetime.now().strftime("%d-%m-%Y %H:%M:%S")
                currentTime=currentTime+".jpg"
                img_name = "unknowns/"+currentTime
                cv2.imwrite(img_name, frame)
                #print("{} written!".format(img_name))
                
            
        
        # loop over the recognized faces
        for ((top, right, bottom, left), name) in zip(boxes, names):
            # draw the predicted face name on the image - color is in BGR
            cv2.rectangle(frame, (left, top), (right, bottom),
                (0, 255, 225), 2)
            y = top - 15 if top - 15 > 15 else top + 15
            cv2.putText(frame, name, (left, y), cv2.FONT_HERSHEY_SIMPLEX,
                .8, (0, 255, 255), 2)

        # display the image to our screen
        cv2.imshow("Facial Recognition is Running", frame)
        key = cv2.waitKey(1) & 0xFF

        # quit when 'q' key is pressed
        if key == ord("q"):
            break

        # update the FPS counter
        fps.update()

    # stop the timer and display FPS information
    fps.stop()
    print("[INFO] elasped time: {:.2f}".format(fps.elapsed()))
    print("[INFO] approx. FPS: {:.2f}".format(fps.fps()))

    # do a bit of cleanup
    cv2.destroyAllWindows()
    vs.stop()

def sendMail(timeNow):
    smtp_server = "smtp.gmail.com"
    port = 587  # For starttls
    sender_email = "alamabrouk007@gmail.com"
   # password = input("donner le password: ")
    password = "bac2018/@142452*"

    # Create a secure SSL context
    context = ssl.create_default_context()

    # Try to log in to server and send email
    try:
        server = smtplib.SMTP(smtp_server,port)
        server.ehlo() # Can be omitted
        server.starttls(context=context) # Secure the connection
        server.ehlo() # Can be omitted
        server.login(sender_email, password)
        
        message = MIMEMultipart("alternative")
        message["Subject"] = "Unknown Activity !!"
        message["From"] = sender_email
        message["To"] = "ala.mabrouk@etudiant-isi.utm.tn"
        
        # Create the plain-text and HTML version of your message
        text = """\
        Unknown person is detected in your workstation,
        At"""+timeNow+"""
        Image is Saved in data base in case of unfortunate event
        Send Police ?
        www.Pointiini.tn"""
        html = """\
        <html>
          <body>
            <p>Unknown person is detected in your workstation<br>
            AT """+timeNow+"""<br>
               Image is Saved in data base in case of unfortunate event<br>
               <a href="http://www.realpython.com">Send Police now ?</a> 
           
               
            </p>
          </body>
        </html>
        """

        # Turn these into plain/html MIMEText objects
        part1 = MIMEText(text, "plain")
        part2 = MIMEText(html, "html")

        # Add HTML/plain-text parts to MIMEMultipart message
        # The email client will try to render the last part first
        message.attach(part1)
        message.attach(part2)
        server.sendmail("alamabrouk007@gmail.com","ala.mabrouk@etudiant-isi.utm.tn",message.as_string())
    except Exception as e:
            # Print any error messages to stdout
        print(e)
    finally:
        server.quit()

def read():
    temp=[]
    users=db.child("user").get()
    for user in users.each():
        temp.append(user.val())
    return temp
    
def delete_data():
    selected_item = my_tree.selection()[0]
    deleteData = str(my_tree.item(selected_item)['values'][0])
    personName=str(my_tree.item(selected_item)['values'][1])+" "+str(my_tree.item(selected_item)['values'][2])
    rep=tkinter.messagebox.askyesno(title="Supprimer utilisateur ?", message="Voulez vous vraiment supprimer l'utilisateur ?")
    if rep == True:
        #delete(deleteData)
        print("deletting:")
        print(deleteData)
        values=db.child("user").get()
        for user in values.each():
            if user.val()["Id"]==deleteData:
                db.child("user").child(user.key()).remove()
       
        shutil.rmtree("dataset/"+personName)
        print(personName+" folder deleted !")
      
                    
    #else
    for data in my_tree.get_children():
        my_tree.delete(data)
        
    # for result in read():
        # my_tree.insert(parent='', index='end',  values=(result["Id"],result["Name"],result["LastName"],result["Birthdate"],result["Adresse"],result["Tel"],), tag="orow")


    for result in read():
        my_tree.insert(parent='', index='end',  values=(result["Id"],result["Name"],result["LastName"],result["Birthdate"],result["Adresse"],result["Tel"],), tag="orow")

        my_tree.tag_configure('orow', background='#EEEEEE')
        my_tree.grid(row=1, column=5, columnspan=4, rowspan=5, padx=10, pady=10)


titleLabel = Label(root, text=storeName, font=('Arial bold', 30), bd=2)
titleLabel.grid(row=0, column=0, columnspan=8, padx=20, pady=20)
#graphical GUI
#idLabel = Label(root, text="ID", font=('Arial bold', 15))
nameLabel = Label(root, text="Name", font=('Arial bold', 15))
lastnameLabel = Label(root, text="LastName", font=('Arial bold', 15))
birthdateLabel=Label(root, text="Birthdate", font=('Arial bold', 15))
AdresseLabel=Label(root, text="Adresse", font=('Arial bold', 15))
TelLabel=Label(root, text="Tel", font=('Arial bold', 15))
MailLabel=Label(root, text="Mail", font=('Arial bold', 15))

#idLabel.grid(row=1, column=0, padx=10, pady=10)
nameLabel.grid(row=2, column=0, padx=10, pady=10)
lastnameLabel.grid(row=3, column=0, padx=10, pady=10)
birthdateLabel.grid(row=4, column=0, padx=10, pady=10)
AdresseLabel.grid(row=5, column=0, padx=10, pady=10)
TelLabel.grid(row=6, column=0, padx=10, pady=10)
MailLabel.grid(row=7, column=0, padx=10, pady=10)


#graphical GUI 
#entryId = Entry(root, width=25, bd=5, font=('Arial bold', 15))
entryName = Entry(root, width=25, bd=5, font=('Arial bold', 15))
entryLastName = Entry(root, width=25, bd=5, font=('Arial bold', 15))
entryAdresse = Entry(root, width=25, bd=5, font=('Arial bold', 15))
entryMail = Entry(root, width=25, bd=5, font=('Arial bold', 15))
entryBirthdate = Entry(root, width=25, bd=5, font=('Arial bold', 15))
entryTel = Entry(root, width=25, bd=5, font=('Arial bold', 15))


#entryId.grid(row=1, column=1, columnspan=3, padx=5, pady=5)
entryName.grid(row=2, column=1, columnspan=3, padx=5, pady=5)
entryLastName.grid(row=3, column=1, columnspan=3, padx=5, pady=5)
entryBirthdate.grid(row=4, column=1, columnspan=3, padx=5, pady=5)
entryAdresse.grid(row=5, column=1, columnspan=3, padx=5, pady=5)
entryTel.grid(row=6, column=1, columnspan=3, padx=5, pady=5)
entryMail.grid(row=7, column=1, columnspan=3, padx=5, pady=5)



buttonEnter = Button(
    root, text="Add", padx=5, pady=5, width=20,
    bd=3, font=('Arial', 15), bg="#0099ff", command=insert_user)
buttonEnter.grid(row=8, column=1, columnspan=1)


buttonDelete = Button(
    root, text="Delete", padx=5, pady=5, width=20,
    bd=3, font=('Arial', 15), bg="#e62e00", command=delete_data)
buttonDelete.grid(row=8, column=2, columnspan=1)

buttonScan= Button(
    root, text="SCAN MODE", padx=10, pady=5, width=20,
    bd=3, font=('Arial', 15), bg="#008000", command=scanPerson)
buttonScan.grid(row=12, column=2, columnspan=1)

buttonTrainAll= Button(
    root, text="TRAIN ALL", padx=10, pady=5, width=20,
    bd=3, font=('Arial', 15), bg="#808080", command=trainning)
buttonTrainAll.grid(row=12, column=1, columnspan=1)

# buttonTrainAll= Button(
    # root, text="SEND MAIL", padx=10, pady=5, width=20,
    # bd=3, font=('Arial', 15), bg="#808080", command=sendMail)
# buttonTrainAll.grid(row=14, column=0, columnspan=1)

style = ttk.Style()
style.configure("Treeview.Heading", font=('Arial bold', 15))

my_tree['columns'] = ("ID", "Name", "Lastname","Birthdate","Adresse","Tel")
my_tree.column("#0", width=0, stretch=NO)
my_tree.column("ID", anchor=W, width=120)
my_tree.column("Name", anchor=W, width=150)
my_tree.column("Lastname", anchor=W, width=150)
my_tree.column("Birthdate", anchor=W, width=120)
my_tree.column("Adresse", anchor=W, width=200)
my_tree.column("Tel", anchor=W, width=200)


my_tree.heading("ID", text="ID", anchor=W)
my_tree.heading("Name", text="Name", anchor=W)
my_tree.heading("Lastname", text="Lastname", anchor=W)
my_tree.heading("Birthdate", text="Birthdate", anchor=W)
my_tree.heading("Adresse", text="Adresse", anchor=W)
my_tree.heading("Tel", text="Tel", anchor=W)


for data in my_tree.get_children():
    my_tree.delete(data)

for result in read():
    my_tree.insert(parent='', index='end',  values=(result["Id"],result["Name"],result["LastName"],result["Birthdate"],result["Adresse"],result["Tel"],), tag="orow")


my_tree.tag_configure('orow', background='#EEEEEE', font=('Arial bold', 15))
my_tree.grid(row=1, column=5, columnspan=4, rowspan=5, padx=10, pady=10)

root.mainloop()



