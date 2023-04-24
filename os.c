//Write a program to create a n child process using

#include <stdio.h>
#include <stdlib.h>
int main()
{
    int count=0;
    printf("How many Processes do you want to create: ");
    scanf("%d", &count);
  for (int i = 0; i < count; i++)
  {
    if (fork() == 0)
	{
	  printf ("[son] pid %d from [parent] pid %d\n", getpid (), getppid ());
	  exit(0);
	}
  }

 wait(NULL);
}

//Write a program to check if file exists or not
#include <stdio.h>

int main()
{
    FILE *fp;
    char name[20];
    printf("Enter file name: ");
    scanf("%s", name);
    printf("Your file name is %s", name);
    fp = fopen(name, "r");
    if(fp==NULL)
    {
        printf("\n File does not exists");
        return 0;
    }
    else
    {
        printf("\nFile Exists");
    }

    return 0;
}

// Write a c program to list all files and subdirectories in the directory 

#include <stdio.h>
#include <dirent.h>
int main(void)
{
    struct dirent *de; //pointer for directory entry
    DIR *dr = opendir(".");
    if (dr==NULL)
    {
        printf("Could not open current directory ");
        return(0);
    }
    while((de= readdir(dr)) != NULL){
        printf("%s\n", de->d_name);
    }
    closedir(dr);
}



//WAP to read a file copy its contents and remove first file.
#include<stdio.h>
int main()
{
    FILE *fp1,*fp2;
    char fname1[11], ch=' ',fname2[11];
    printf("\nEnter source File Name:");
    scanf("%s",fname1);
    fp1=fopen(fname1,"r");
    if(fp1==NULL)
    {
        printf("Cannot open file");
    }
    else
    {
    printf("\nEnter Destination File Name:");
    scanf("%s",fname2);
     fp2=fopen(fname2,"w");
     if(fp2==NULL)
     {
         printf("Cannot create file");
     }
     else{
        while(1)
        {
            ch=fgetc(fp1);
            if(ch==EOF) break;
            fputc(ch,fp2);
        }
    }}
    fclose(fp1);
    fclose(fp2);
    remove(fname1);
return 0;
}

//WAP To create n children process form parent process
#include<stdio.h>
int main()
{int i,n;
printf("Enter no of child processes you want:");
scanf("%d",&n);
    for(i=0;i<n;i++) // loop will run n times (n=5)
    {
        if(fork() == 0)
        {
            printf("[son] pid %d from [parent] pid %d\n",getpid(),getppid());
            //exit(0);
        }
    }
    for(int i=0;i<n;i++) // loop will run n times (n=5)
    wait(NULL);
 }
 
 
 
 
//WAP to check whether file exists or not
#include<stdio.h>
#include <string.h>
#include <dirent.h>
int main() {
    char filename[11];
    DIR *dir;
    struct dirent *ent;
    printf("Enter file name to search: ");
    scanf("%s", filename);
    dir = opendir(".");
    if (dir != NULL) {
        while ((ent = readdir(dir)) != NULL) {
            if (strcmp(ent->d_name, filename) == 0) {
                printf("%s found in current directory.\n", filename);
                closedir(dir);
                return 0;
            }
        }
        printf("%s not found in current directory.\n", filename);
        closedir(dir);
    } else {
        printf("Error: could not open directory.\n");
        return 1;
    }
    return 0;
}

#include<stdio.h>
int main()
{ char fname1[11],fname2[11],ch=' ';
FILE *fp1,*fp2;
printf("\nEnter file name:");
scanf("%s",fname1);
fp1=fopen(fname1,"r");
if(fp1==NULL)
   printf("Unable to open file");

else{
    printf("\nEnter second file name");
    scanf("%s",fname2);
    fp2=fopen(fname2,"w");
    if(fp2==NULL)
    {
        printf("Unable to create file");
    }
    else
    {
        while(1)
        {
            ch=fgetc(fp1);
            if(ch==EOF) break;
            if(ch>='A'&&ch<='Z')
            fputc(ch+32,fp2);
            else if(ch>='a'&&ch<='z')
            fputc(ch-32,fp2);
            else
            fputc(ch,fp2);
        }
        printf("files is copied");
    }
    
}

fclose(fp1);
fclose(fp2);
return 0;
}
