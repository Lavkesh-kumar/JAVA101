

packages help to differentiate application.

packages can be seen individual folder

we can create package inside package (folder inside folder)


-- we can use class of one package in another by importing it.

how to create package : 

package com.lavkesh.src.app // it is created like it




--------------------------------------------------------------
ACCESS MODIFIERS
--------------------------------------------------------------
default variables are only accessed with in same package

In order access in some other package, we have to make it public : 

Make variables protected in order to get access in it's subclass.


| Scope                        | public | default | protected | private |
|------------------------------|--------|---------|-----------|---------|
| same class                   | YES    | YES     | YES       | YES     |
| same package subclass        | YES    | YES     | YES       | NO      |
| same package non-subclass    | YES    | YES     | YES       | NO      |
| different package subclass   | YES    | NO      | YES       | NO      |
| diff package non-subclass    | YES    | NO      | NO        | NO      |




with final keyword, we can't override functions : 
with final clas, we can't inherit class :
