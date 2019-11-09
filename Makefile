

all:
	javac -d bin *.java

run:
	java -cp bin Main

clean:
	rm bin/*
