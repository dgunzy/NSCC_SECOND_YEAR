//
// Created by Dan Guns on 2023-11-28.
//
#ifndef ASSIGNMENT3_CONTACTUTILITY_H
#define ASSIGNMENT3_CONTACTUTILITY_H
#include "Contact.h"
class ContactUtility {
private:
    void sortContacts(std::vector<Contact*>& contacts);
    bool checkIfContactExists(std::vector<Contact*>& contacts, std::string_view nameToCheck);
public:
    void addContact(std::vector<Contact*>& contacts);
    void printContacts(std::vector<Contact*>& contacts);
    void addFriend(std::vector<Contact*>& contacts);
    void printFriends(std::vector<Contact*>& contacts);
    void deleteContact(std::vector<Contact*>& contacts);
};

#endif //ASSIGNMENT3_CONTACTUTILITY_H
