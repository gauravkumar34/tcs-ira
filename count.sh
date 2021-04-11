#* User Input
# echo "Enter the user Name: "
# read first_name
# echo "your name is $first_name"
# echo
# echo "Enter others user names :"
# read name1 name2 name3
# echo "$name1, $name2, $name3 are the other users."
# #* Date
# d=`date +%m-%d-%Y`
# echo $d
# #* Arithematic operations
# Sum=$((10+3))
# echo "Sum = $Sum"

# x=9
# y=5
# echo "Sum = $(($x + $y))" #one
# echo "a=10, b=3"  
# echo "c is the value of addition c=a+b"  
# a=10  
# b=3  
# echo "c= `expr $a + $b`"  #second


sort -k3,3 -rn -t" " | head -n1 | awk '{print $2}'