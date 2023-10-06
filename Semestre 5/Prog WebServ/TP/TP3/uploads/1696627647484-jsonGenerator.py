def generateJSON(tags):
    print("Generating JSON...")

def fillJSON_elem(tags):
    for i in range(len(tags)):
        print("Tag " + str(i+1) + ": " + tags[i])

def generateJSON_elem():
    print("Nombre de tags: ")
    nbTags = int(input())
    tags = []
    for i in range(nbTags):
        print("Tag " + str(i+1) + ": ")
        tags.append(input())
    fillJSON_elem(tags)

def main() :
    while (True):
        print("1. Generate JSON")
        print("2. Exit")
        choice = int(input("Enter your choice: "))
        if choice == 1:
            generateJSON_elem()
        elif choice == 2:
            break
        else:
            print("Invalid choice")
            continue

if __name__ == "__main__":
    main()
    