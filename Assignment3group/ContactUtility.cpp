#include "Contact.h"
#include "ContactUtility.h"
#include <iostream>


void ContactUtility::addContact(std::vector<Contact*>& contacts) {
    std::cout << "Enter the name of the Contact:";
    std::string userName {};
    getline(std::cin, userName );
    std::cout << "Enter the age of the Contact:";
    int userAge {};
    std::cin.clear();
    std::cin >> userAge;

    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    std::cout << "\n";
    auto* newContact = new Contact(new std::string(userName), userAge);
    contacts.push_back(newContact);
}

void ContactUtility::sortContacts(std::vector<Contact *>& contacts) {
    std::sort(contacts.begin(), contacts.end(), [](Contact* a, Contact* b) {
        return *(a->m_name) < *(b->m_name);
    });
}

bool ContactUtility::checkIfContactExists(std::vector<Contact *> &contacts, std::string_view nameToCheck) {
    auto iterator = std::find_if(contacts.begin(), contacts.end(), [&](Contact* a) {
        return *(a->m_name) == nameToCheck;
    });
    if(iterator != contacts.end()) {
        return true;
    } else {
        return false;
    }
}

void ContactUtility::printContacts(std::vector<Contact *>& contacts) {
    sortContacts(contacts);
    for(int i = 0; i < contacts.size(); i ++) {
        std::cout <<"Name: "  << (*contacts.at(i)).m_name->c_str() << " Age:" <<  (*contacts.at(i)).m_age <<std::endl;
    }
}

void ContactUtility::addFriend(std::vector<Contact *> &contacts) {
    std::cout << "Enter the name of the Contact you want to add a friend too:";
    std::string userToAddFriend{};
    getline(std::cin, userToAddFriend);
    std::cin.clear();
    if (checkIfContactExists(contacts, userToAddFriend)) {
        std::cout << "That contact exits! " << std::endl;
    } else {
        std::cout << "That contact does not exist!" << std::endl;
        return;
    }
    std::cout << "Enter the name of the Contact you want to add to " << userToAddFriend << "'s friends list:";
    std::string userFriend{};
    getline(std::cin, userFriend);
    std::cin.clear();
    if (checkIfContactExists(contacts, userFriend)) {
        std::cout << "That contact exits! " << std::endl;
    } else {
        std::cout << "That contact does not exist!" << std::endl;
        return;
    }
    auto iteratorToFriend  = std::find_if(contacts.begin(), contacts.end(), [&](Contact *a) {
        return *(a->m_name) == userFriend;
    });
    auto iteratorToContact  = std::find_if(contacts.begin(), contacts.end(), [&](Contact *a) {
        return *(a->m_name) == userToAddFriend;
    });

    (*iteratorToContact)->addFriend(*iteratorToFriend);

    std::cout << userFriend << " added to " << userToAddFriend << " friends!" << std::endl;
}

void ContactUtility::printFriends(std::vector<Contact *> &contacts) {
    std::cout << "Enter the contact you want to print friends from:";
    std::string contactToCheckFriends{};
    getline(std::cin,contactToCheckFriends);
    std::cin.clear();
    if(checkIfContactExists(contacts, contactToCheckFriends)) {
        auto iterator = std::find_if(contacts.begin(), contacts.end(), [&](Contact *a) {
            return *(a->m_name) == contactToCheckFriends;});
        if(!(*iterator)->m_friends.empty()) {
            for(auto & m_friend : (*iterator)->m_friends) {
                std::cout << *(m_friend->m_name) << std::endl;
            }
        } else {
            std::cout << "Contact has no friends :( " << std::endl;
        }
    } else {
        std::cout << "Contact does not exist!" << std::endl;
    }
}

void ContactUtility::deleteContact(std::vector<Contact *> &contacts) {
    std::cout << "Enter the contact you want to delete:";
    std::string contactToDelete{};
    getline(std::cin,contactToDelete);
    std::cin.clear();
    if (checkIfContactExists(contacts, contactToDelete)) {
        std::cout << "That contact exits! " << std::endl;
    } else {
        std::cout << "That contact does not exist!" << std::endl;
        return;
    }
    auto iterator = std::find_if(contacts.begin(), contacts.end(), [&](Contact *a) {
        return *(a->m_name) == contactToDelete;});

    for(auto & contact : contacts) {
        contact->removeFriend(contactToDelete);
    }

    delete *iterator;
    contacts.erase(iterator);
}