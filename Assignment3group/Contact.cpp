#include "Contact.h"
#include <algorithm>
#include <iostream>

Contact::Contact(std::string *name, int age) {
    this->m_name = name;
    this->m_age = age;
}

void Contact::addFriend(Contact *newFriend) {
    m_friends.push_back(newFriend);
}

void Contact::removeFriend(std::string_view friendName) {
    auto iter =  std::find_if(m_friends.begin(), m_friends.end(), [&friendName] (Contact* object) {
        return *object->m_name == friendName; });
    if(iter != m_friends.end()) {
        m_friends.erase(iter);
        std::cout << "The friend " << friendName << " was erased from " << *(this->m_name) << "'s friends list.\n";
     }
}

