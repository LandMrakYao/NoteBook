# Git命令

初始化一个Git仓库使用   git init命令

添加文件到Git仓库：

1. 使用git add<file> 可反复多次使用，添加多个文件；
2. 使用git commit -m<message>，完成

git log 显示从最近到最远的提交日志

git log --pretty=online简化信息

git reset --hard HEAD^回退版本使用  (如果是上个版本使用^如果多个版本用~+数字)

git reflog 记录每一次命令，找到需要的commit id即可找回原来的版本

## 工作区和暂存区

工作区就是在电脑能看到的目录

工作区有一个隐藏的目录.git是Git的版本库

Git的版本库里存了很多东西，其中最重要的就是stage的暂存区和Git自动创建的第一个分支master及指向master的指针HEAD

当我们使用git add时实际上是将文件添加到暂存区

然后使用git commit将暂存区的文件提交到当前分支

## 管理修改

git diff HEAD -- readme.txt(文件名) 可以查看工作区和版本库里面最新版本的区别

进行修改时要注意顺序：

第一次修改->git add ->第二次修改->git add ->git commit

**注意：第一次修改使用add是将其放在暂存区，第二次修改如果直接使用commit是将第一次暂存区中的提交而第二次修改的并没有在暂存区**

## 撤销修改

当直接丢弃工作区的修改时，用命令git checkout -- file

当丢弃修改暂存区的文件时，第一步用命令 git reset HEAD <file> 退回到工作区，然后使用第一步

当提交了不合适的修改到版本库时，使用 git reset -- hard HEAD^

## 删除文件

命令 git rm用于删除一个文件。

一般情况下，通常在文件管理器中把没用的文件删了，用rm file

如果确实要从版本库中删除该文件，用git rm file，并且git commit

如果是删错了，使用git checkout --  <file>

git checkout 其实是用版本库里的版本替换工作区的版本

## 远程仓库

关联一个远程库，使用命令 git remote add origin git@LandMrakYao:路径/name.git

关联后，使用命令git push -u origin master推送master分支的所有内容。

此后，每次本地提交后，只要有必要，就可以使用命令git push origin master推送修改

**从远程库克隆**

git clone +地址   <!--将GitHub上的项目名放在本地项目录-->

cd +项目文件      <!--进入项目文件-->

git add **.**               <!--添加项目文件中的所有文件-->

git commit -m "提交信息"

git push -u origin master  <!--把本地仓库push到github上-->

<<<<<<< HEAD
### 创建与合并分支
=======
### 创建与合并分支

查看分支：git branch

创建分支：git branch <name>

切换分支：git checkout <name>

创建+切换分支：git checkout -b <name>

合并某分支到当前分支：git merge <name>

删除分支：git branch -d <name>
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac
