main=main

package=je/collections
package2=je/files
package3=je/other
package4=je/other/pointconnector
package5=je/visual
package6=je/visual/coolbuttons
package7=je/webdev

folder=je
extention=class


default: jc


jc compile:
	test -d bin || mkdir bin
	test -d src2 || mkdir src2
	cp src/${package}/*.java src2
	cp src/${package2}/*.java src2
	cp src/${package3}/*.java src2
	cp src/${package4}/*.java src2
	cp src/${package5}/*.java src2
	cp src/${package6}/*.java src2
	cp src/${package7}/*.java src2
	javac -d bin src2/*.java
	javac -d . src2/*.java
	rm -R src2
	@echo "Compiled!"

# Runs the main program.
run runCW:
	@echo "Running!"
	java -classpath bin ${package7}/${main}


# Creates a .jar file that can be imported into another project.
create-jar create_jar createJar export:
	jar cf JExtras.jar ${folder}/*
	rm -R ${folder}
	@echo "Jar file created!"


# Removes the bin folder that contains all the .class files
clean:
	test -d bin || mkdir bin
	rm -R bin
	test -d src2 || mkdir src2
	rm -R src2
	test -d ${folder} || mkdir ${folder}
	rm -R ${folder}
	@echo "Cleaned!"

cr: compile run
