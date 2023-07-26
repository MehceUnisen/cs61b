def label(tree):
    if type(tree) is Tree:
        return tree.label
    return tree[0]

def branch(tree):
    return tree[1:]

def is_leaf(tree):
    if tree.branches is Tree.empty:
        return True
    return False

class Tree():
    empty = []
    def __init__(self, label, branches = empty):
        self.label = label
        self.branches = branches

def double_tree(tree):
    tree.label *= 2
    for b in tree.branches:
        double_tree(b)
    print(tree.label)



def rint_tree(t, indent=0):
    print(" " * indent, t.label)
    for b in t.branches:
        rint_tree(b, indent + 1)

def print_tree(tree):
    print(tree.label)
    for b in tree.branches:
        print_tree(b)